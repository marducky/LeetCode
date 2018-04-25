package majors.openSource.Generate2Word;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.*;
import org.apache.xmlbeans.impl.xb.xmlschema.SpaceAttribute;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class WordCommonUtils {

    // 替换 复制 表格 段落

    /*------------------------------------Word 插入书签---------------------------------------------------  */

    /**
     * @Description: 添加书签
     */
    public void addParagraphContentBookmarkBasicStyle(XWPFParagraph p,
                                                      String content, BigInteger markId, String bookMarkName,
                                                      boolean isInsert, boolean isNewLine, String fontFamily,
                                                      String fontSize, String colorVal, boolean isBlod,
                                                      boolean isUnderLine, String underLineColor,
                                                      STUnderline.Enum underStyle, boolean isItalic, boolean isStrike) {
        CTBookmark bookStart = p.getCTP().addNewBookmarkStart();
        bookStart.setId(markId);
        bookStart.setName(bookMarkName);

        XWPFRun pRun = getOrAddParagraphFirstRun(p, isInsert, isNewLine);
        setParagraphRunFontInfo(p, pRun, content, fontFamily, fontSize);
        setParagraphTextStyleInfo(p, pRun, colorVal, isBlod, isUnderLine,
                underLineColor, underStyle, isItalic, isStrike, false, false,
                false, false, false, false, false, null, false, null, false,
                null, null, null, 0, 0, 0);
        CTMarkupRange bookEnd = p.getCTP().addNewBookmarkEnd();
        bookEnd.setId(markId);

    }

    /**
     * @Description: 添加书签
     */
    public void addParagraphContentBookmark(XWPFParagraph p, String content,
                                            BigInteger markId, String bookMarkName, boolean isInsert,
                                            boolean isNewLine, String fontFamily, String fontSize,
                                            String colorVal, boolean isBlod, boolean isUnderLine,
                                            String underLineColor, STUnderline.Enum underStyle,
                                            boolean isItalic, boolean isStrike, boolean isDStrike,
                                            boolean isShadow, boolean isVanish, boolean isEmboss,
                                            boolean isImprint, boolean isOutline, boolean isEm,
                                            STEm.Enum emType, boolean isHightLight,
                                            STHighlightColor.Enum hightStyle, boolean isShd,
                                            STShd.Enum shdStyle, String shdColor, VerticalAlign verticalAlign,
                                            int position, int spacingValue, int indent) {
        CTBookmark bookStart = p.getCTP().addNewBookmarkStart();
        bookStart.setId(markId);
        bookStart.setName(bookMarkName);

        XWPFRun pRun = getOrAddParagraphFirstRun(p, isInsert, isNewLine);
        setParagraphRunFontInfo(p, pRun, content, fontFamily, fontSize);
        setParagraphTextStyleInfo(p, pRun, colorVal, isBlod, isUnderLine,
                underLineColor, underStyle, isItalic, isStrike, isDStrike,
                isShadow, isVanish, isEmboss, isImprint, isOutline, isEm,
                emType, isHightLight, hightStyle, isShd, shdStyle, shdColor,
                verticalAlign, position, spacingValue, indent);

        CTMarkupRange bookEnd = p.getCTP().addNewBookmarkEnd();
        bookEnd.setId(markId);

    }

    /*------------------------------------Word 插入超链接---------------------------------------------------  */

    /**
     * @Description: 默认的超链接样式
     */
    public void addParagraphTextHyperlinkBasicStyle(XWPFParagraph paragraph,
                                                    String url, String text, String fontFamily, String fontSize,
                                                    String colorVal, boolean isBlod, boolean isItalic, boolean isStrike) {
        addParagraphTextHyperlink(paragraph, url, text, fontFamily, fontSize,
                colorVal, isBlod, true, "0000FF", STUnderline.SINGLE, isItalic,
                isStrike, false, false, false, false, false, false, false,
                null, false, null, false, null, null, null, 0, 0, 0);
    }

    /**
     * @Description: 设置超链接样式
     */
    public void addParagraphTextHyperlink(XWPFParagraph paragraph, String url,
                                          String text, String fontFamily, String fontSize, String colorVal,
                                          boolean isBlod, boolean isUnderLine, String underLineColor,
                                          STUnderline.Enum underStyle, boolean isItalic, boolean isStrike,
                                          boolean isDStrike, boolean isShadow, boolean isVanish,
                                          boolean isEmboss, boolean isImprint, boolean isOutline,
                                          boolean isEm, STEm.Enum emType, boolean isHightLight,
                                          STHighlightColor.Enum hightStyle, boolean isShd,
                                          STShd.Enum shdStyle, String shdColor,
                                          STVerticalAlignRun.Enum verticalAlign, int position,
                                          int spacingValue, int indent) {
        // Add the link as External relationship
        String id = paragraph
                .getDocument()
                .getPackagePart()
                .addExternalRelationship(url,
                        XWPFRelation.HYPERLINK.getRelation()).getId();
        // Append the link and bind it to the relationship
        CTHyperlink cLink = paragraph.getCTP().addNewHyperlink();
        cLink.setId(id);

        // Create the linked text
        CTText ctText = CTText.Factory.newInstance();
        ctText.setStringValue(text);
        CTR ctr = CTR.Factory.newInstance();
        CTRPr rpr = ctr.addNewRPr();

        if (StringUtils.isNotBlank(fontFamily)) {
            // 设置字体
            CTFonts fonts = rpr.isSetRFonts() ? rpr.getRFonts() : rpr
                    .addNewRFonts();
            fonts.setAscii(fontFamily);
            fonts.setEastAsia(fontFamily);
            fonts.setHAnsi(fontFamily);
        }
        if (StringUtils.isNotBlank(fontSize)) {
            // 设置字体大小
            CTHpsMeasure sz = rpr.isSetSz() ? rpr.getSz() : rpr.addNewSz();
            sz.setVal(new BigInteger(fontSize));

            CTHpsMeasure szCs = rpr.isSetSzCs() ? rpr.getSzCs() : rpr
                    .addNewSzCs();
            szCs.setVal(new BigInteger(fontSize));
        }
        // 设置超链接样式
        // 字体颜色
        if (StringUtils.isNotBlank(colorVal)) {
            CTColor color = CTColor.Factory.newInstance();
            color.setVal(colorVal);
            rpr.setColor(color);
        }
        // 加粗
        if (isBlod) {
            CTOnOff bCtOnOff = rpr.addNewB();
            bCtOnOff.setVal(STOnOff.TRUE);
        }
        // 下划线
        if (isUnderLine) {
            CTUnderline udLine = rpr.addNewU();
            udLine.setVal(underStyle);
            udLine.setColor(underLineColor);
        }
        // 倾斜
        if (isItalic) {
            CTOnOff iCtOnOff = rpr.addNewI();
            iCtOnOff.setVal(STOnOff.TRUE);
        }
        // 删除线
        if (isStrike) {
            CTOnOff sCtOnOff = rpr.addNewStrike();
            sCtOnOff.setVal(STOnOff.TRUE);
        }
        // 双删除线
        if (isDStrike) {
            CTOnOff dsCtOnOff = rpr.addNewDstrike();
            dsCtOnOff.setVal(STOnOff.TRUE);
        }
        // 阴影
        if (isShadow) {
            CTOnOff shadowCtOnOff = rpr.addNewShadow();
            shadowCtOnOff.setVal(STOnOff.TRUE);
        }
        // 隐藏
        if (isVanish) {
            CTOnOff vanishCtOnOff = rpr.addNewVanish();
            vanishCtOnOff.setVal(STOnOff.TRUE);
        }
        // 阳文
        if (isEmboss) {
            CTOnOff embossCtOnOff = rpr.addNewEmboss();
            embossCtOnOff.setVal(STOnOff.TRUE);
        }
        // 阴文
        if (isImprint) {
            CTOnOff isImprintCtOnOff = rpr.addNewImprint();
            isImprintCtOnOff.setVal(STOnOff.TRUE);
        }
        // 空心
        if (isOutline) {
            CTOnOff isOutlineCtOnOff = rpr.addNewOutline();
            isOutlineCtOnOff.setVal(STOnOff.TRUE);
        }
        // 着重号
        if (isEm) {
            CTEm em = rpr.addNewEm();
            em.setVal(emType);
        }
        // 突出显示文本
        if (isHightLight) {
            if (hightStyle != null) {
                CTHighlight hightLight = rpr.addNewHighlight();
                hightLight.setVal(hightStyle);
            }
        }
        if (isShd) {
            // 设置底纹
            CTShd shd = rpr.addNewShd();
            if (shdStyle != null) {
                shd.setVal(shdStyle);
            }
            if (shdColor != null) {
                shd.setColor(shdColor);
            }
        }
        // 上标下标
        if (verticalAlign != null) {
            rpr.addNewVertAlign().setVal(verticalAlign);
        }
        // 设置文本位置
        rpr.addNewPosition().setVal(new BigInteger(String.valueOf(position)));
        if (spacingValue != 0) {
            // 设置字符间距信息
            CTSignedTwipsMeasure ctSTwipsMeasure = rpr.addNewSpacing();
            ctSTwipsMeasure
                    .setVal(new BigInteger(String.valueOf(spacingValue)));
        }
        // 设置字符间距缩进
        if (indent > 0) {
            CTTextScale paramCTTextScale = rpr.addNewW();
            paramCTTextScale.setVal(indent);
        }
        ctr.setTArray(new CTText[]{ctText});
        cLink.setRArray(new CTR[]{ctr});
    }

    /*------------------------------------Word 页眉页脚相关---------------------------------------------------  */

    /**
     * @Description: 页脚:显示页码信息
     */
    public void simpleNumberFooter(XWPFDocument document) throws Exception {
        CTP ctp = CTP.Factory.newInstance();
        XWPFParagraph codePara = new XWPFParagraph(ctp, document);
        XWPFRun r1 = codePara.createRun();
        r1.setText("第");
        setParagraphRunFontInfo(codePara, r1, null, "微软雅黑", "22");

        r1 = codePara.createRun();
        CTFldChar fldChar = r1.getCTR().addNewFldChar();
        fldChar.setFldCharType(STFldCharType.BEGIN);

        r1 = codePara.createRun();
        CTText ctText = r1.getCTR().addNewInstrText();
        ctText.setStringValue("PAGE  \\* MERGEFORMAT");
        ctText.setSpace(SpaceAttribute.Space.PRESERVE);
        setParagraphRunFontInfo(codePara, r1, null, "微软雅黑", "22");

        fldChar = r1.getCTR().addNewFldChar();
        fldChar.setFldCharType(STFldCharType.END);

        r1 = codePara.createRun();
        r1.setText("页 总共");
        setParagraphRunFontInfo(codePara, r1, null, "微软雅黑", "22");

        r1 = codePara.createRun();
        fldChar = r1.getCTR().addNewFldChar();
        fldChar.setFldCharType(STFldCharType.BEGIN);

        r1 = codePara.createRun();
        ctText = r1.getCTR().addNewInstrText();
        ctText.setStringValue("NUMPAGES  \\* MERGEFORMAT ");
        ctText.setSpace(SpaceAttribute.Space.PRESERVE);
        setParagraphRunFontInfo(codePara, r1, null, "微软雅黑", "22");

        fldChar = r1.getCTR().addNewFldChar();
        fldChar.setFldCharType(STFldCharType.END);

        r1 = codePara.createRun();
        r1.setText("页");
        setParagraphRunFontInfo(codePara, r1, null, "微软雅黑", "22");

        setParagraphAlignInfo(codePara, ParagraphAlignment.CENTER,
                TextAlignment.CENTER);
        codePara.setBorderTop(Borders.THICK);
        XWPFParagraph[] newparagraphs = new XWPFParagraph[1];
        newparagraphs[0] = codePara;
        CTSectPr sectPr = document.getDocument().getBody().addNewSectPr();
        XWPFHeaderFooterPolicy headerFooterPolicy = new XWPFHeaderFooterPolicy(
                document, sectPr);
        headerFooterPolicy.createFooter(STHdrFtr.DEFAULT, newparagraphs);
    }

    /**
     * @Description: 页眉:显示时间信息
     */
    public void simpleDateHeader(XWPFDocument document) throws Exception {
        CTP ctp = CTP.Factory.newInstance();
        XWPFParagraph codePara = new XWPFParagraph(ctp, document);

        XWPFRun r1 = codePara.createRun();
        CTFldChar fldChar = r1.getCTR().addNewFldChar();
        fldChar.setFldCharType(STFldCharType.BEGIN);

        r1 = codePara.createRun();
        CTText ctText = r1.getCTR().addNewInstrText();
        ctText.setStringValue("TIME \\@ \"EEEE\"");
        ctText.setSpace(SpaceAttribute.Space.PRESERVE);
        setParagraphRunFontInfo(codePara, r1, null, "微软雅黑", "22");

        fldChar = r1.getCTR().addNewFldChar();
        fldChar.setFldCharType(STFldCharType.END);

        r1 = codePara.createRun();
        r1.setText("年");
        setParagraphRunFontInfo(codePara, r1, null, "微软雅黑", "22");

        r1 = codePara.createRun();
        fldChar = r1.getCTR().addNewFldChar();
        fldChar.setFldCharType(STFldCharType.BEGIN);

        r1 = codePara.createRun();
        ctText = r1.getCTR().addNewInstrText();
        ctText.setStringValue("TIME \\@ \"O\"");
        ctText.setSpace(SpaceAttribute.Space.PRESERVE);
        setParagraphRunFontInfo(codePara, r1, null, "微软雅黑", "22");

        fldChar = r1.getCTR().addNewFldChar();
        fldChar.setFldCharType(STFldCharType.END);

        r1 = codePara.createRun();
        r1.setText("月");
        r1.setFontSize(11);
        setParagraphRunFontInfo(codePara, r1, null, "微软雅黑", "22");

        r1 = codePara.createRun();
        fldChar = r1.getCTR().addNewFldChar();
        fldChar.setFldCharType(STFldCharType.BEGIN);

        r1 = codePara.createRun();
        ctText = r1.getCTR().addNewInstrText();
        ctText.setStringValue("TIME \\@ \"A\"");
        ctText.setSpace(SpaceAttribute.Space.PRESERVE);
        setParagraphRunFontInfo(codePara, r1, null, "微软雅黑", "22");

        fldChar = r1.getCTR().addNewFldChar();
        fldChar.setFldCharType(STFldCharType.END);

        r1 = codePara.createRun();
        r1.setText("日");
        r1.setFontSize(11);
        setParagraphRunFontInfo(codePara, r1, null, "微软雅黑", "22");

        setParagraphAlignInfo(codePara, ParagraphAlignment.CENTER,
                TextAlignment.CENTER);
        codePara.setBorderBottom(Borders.THICK);
        XWPFParagraph[] newparagraphs = new XWPFParagraph[1];
        newparagraphs[0] = codePara;
        CTSectPr sectPr = document.getDocument().getBody().addNewSectPr();
        XWPFHeaderFooterPolicy headerFooterPolicy = new XWPFHeaderFooterPolicy(
                document, sectPr);
        headerFooterPolicy.createHeader(STHdrFtr.DEFAULT, newparagraphs);
    }

    /*------------------------------------Word 段落相关---------------------------------------------------  */

    /**
     * @Description: 得到段落CTPPr
     */
    public CTPPr getParagraphCTPPr(XWPFParagraph p) {
        CTPPr pPPr = null;
        if (p.getCTP() != null) {
            if (p.getCTP().getPPr() != null) {
                pPPr = p.getCTP().getPPr();
            } else {
                pPPr = p.getCTP().addNewPPr();
            }
        }
        return pPPr;
    }

    /**
     * @Description: 得到XWPFRun的CTRPr
     */
    public CTRPr getRunCTRPr(XWPFParagraph p, XWPFRun pRun) {
        CTRPr pRpr = null;
        if (pRun.getCTR() != null) {
            pRpr = pRun.getCTR().getRPr();
            if (pRpr == null) {
                pRpr = pRun.getCTR().addNewRPr();
            }
        } else {
            pRpr = p.getCTP().addNewR().addNewRPr();
        }
        return pRpr;
    }

    public XWPFRun getOrAddParagraphFirstRun(XWPFParagraph p, boolean isInsert,
                                             boolean isNewLine) {
        XWPFRun pRun = null;
        if (isInsert) {
            pRun = p.createRun();
        } else {
            if (p.getRuns() != null && p.getRuns().size() > 0) {
                pRun = p.getRuns().get(0);
            } else {
                pRun = p.createRun();
            }
        }
        if (isNewLine) {
            pRun.addBreak();
        }
        return pRun;
    }

    public void setParagraphTextFontInfo(XWPFParagraph p, boolean isInsert,
                                         boolean isNewLine, String content, String fontFamily,
                                         String fontSize) {
        XWPFRun pRun = getOrAddParagraphFirstRun(p, isInsert, isNewLine);
        setParagraphRunFontInfo(p, pRun, content, fontFamily, fontSize);
    }

    /**
     * @Description 设置字体信息
     */
    public void setParagraphRunFontInfo(XWPFParagraph p, XWPFRun pRun,
                                        String content, String fontFamily, String fontSize) {
        CTRPr pRpr = getRunCTRPr(p, pRun);
        if (StringUtils.isNotBlank(content)) {
            pRun.setText(content);
        }
        // 设置字体
        CTFonts fonts = pRpr.isSetRFonts() ? pRpr.getRFonts() : pRpr
                .addNewRFonts();
        fonts.setAscii(fontFamily);
        fonts.setEastAsia(fontFamily);
        fonts.setHAnsi(fontFamily);

        // 设置字体大小
        CTHpsMeasure sz = pRpr.isSetSz() ? pRpr.getSz() : pRpr.addNewSz();
        sz.setVal(new BigInteger(fontSize));

        CTHpsMeasure szCs = pRpr.isSetSzCs() ? pRpr.getSzCs() : pRpr
                .addNewSzCs();
        szCs.setVal(new BigInteger(fontSize));
    }

    /**
     * @Description: 设置段落基本样式
     */
    public void setParagraphTextBasicStyleInfo(XWPFParagraph p, XWPFRun pRun,
                                               String colorVal, boolean isBlod, boolean isUnderLine,
                                               String underLineColor, STUnderline.Enum underStyle,
                                               boolean isItalic, boolean isStrike, boolean isHightLight,
                                               STHighlightColor.Enum hightStyle, boolean isShd,
                                               STShd.Enum shdStyle, String shdColor) {
        setParagraphTextStyleInfo(p, pRun, colorVal, isBlod, isUnderLine,
                underLineColor, underStyle, isItalic, isStrike, false, false,
                false, false, false, false, false, null, isHightLight,
                hightStyle, isShd, shdStyle, shdColor, null, 0, 0, 0);
    }

    /**
     * @param verticalAlign : SUPERSCRIPT上标 SUBSCRIPT下标
     * @param position      :字符间距位置：>0提升 <0降低=磅值*2 如3磅=6
     * @param spacingValue  :字符间距间距 >0加宽 <0紧缩 =磅值*20 如2磅=40
     * @param indent        :字符间距缩进 <100 缩
     * @Description: 设置段落文本样式(高亮与底纹显示效果不同)设置字符间距信息(CTSignedTwipsMeasure)
     */
    public void setParagraphTextSimpleStyleInfo(XWPFParagraph p, XWPFRun pRun,
                                                String colorVal, boolean isBlod, boolean isUnderLine,
                                                String underLineColor, STUnderline.Enum underStyle,
                                                boolean isItalic, boolean isStrike, boolean isHightLight,
                                                STHighlightColor.Enum hightStyle, boolean isShd,
                                                STShd.Enum shdStyle, String shdColor, VerticalAlign verticalAlign,
                                                int position, int spacingValue, int indent) {
        setParagraphTextStyleInfo(p, pRun, colorVal, isBlod, isUnderLine,
                underLineColor, underStyle, isItalic, isStrike, false, false,
                false, false, false, false, false, null, isHightLight,
                hightStyle, isShd, shdStyle, shdColor, verticalAlign, position,
                spacingValue, indent);
    }

    /**
     * @param verticalAlign : SUPERSCRIPT上标 SUBSCRIPT下标
     * @param position      :字符间距位置：>0提升 <0降低=磅值*2 如3磅=6
     * @param spacingValue  :字符间距间距 >0加宽 <0紧缩 =磅值*20 如2磅=40
     * @param indent        :字符间距缩进 <100 缩
     * @Description: 设置段落文本样式(高亮与底纹显示效果不同)设置字符间距信息(CTSignedTwipsMeasure)
     */
    public void setParagraphTextStyleInfo(XWPFParagraph p, XWPFRun pRun,
                                          String colorVal, boolean isBlod, boolean isUnderLine,
                                          String underLineColor, STUnderline.Enum underStyle,
                                          boolean isItalic, boolean isStrike, boolean isDStrike,
                                          boolean isShadow, boolean isVanish, boolean isEmboss,
                                          boolean isImprint, boolean isOutline, boolean isEm,
                                          STEm.Enum emType, boolean isHightLight,
                                          STHighlightColor.Enum hightStyle, boolean isShd,
                                          STShd.Enum shdStyle, String shdColor, VerticalAlign verticalAlign,
                                          int position, int spacingValue, int indent) {
        if (pRun == null) {
            return;
        }
        CTRPr pRpr = getRunCTRPr(p, pRun);
        if (colorVal != null) {
            pRun.setColor(colorVal);
        }
        // 设置字体样式
        // 加粗
        if (isBlod) {
            pRun.setBold(isBlod);
        }
        // 倾斜
        if (isItalic) {
            pRun.setItalic(isItalic);
        }
        // 删除线
        if (isStrike) {
            pRun.setStrike(isStrike);
        }
        // 双删除线
        if (isDStrike) {
            CTOnOff dsCtOnOff = pRpr.isSetDstrike() ? pRpr.getDstrike() : pRpr
                    .addNewDstrike();
            dsCtOnOff.setVal(STOnOff.TRUE);
        }
        // 阴影
        if (isShadow) {
            CTOnOff shadowCtOnOff = pRpr.isSetShadow() ? pRpr.getShadow()
                    : pRpr.addNewShadow();
            shadowCtOnOff.setVal(STOnOff.TRUE);
        }
        // 隐藏
        if (isVanish) {
            CTOnOff vanishCtOnOff = pRpr.isSetVanish() ? pRpr.getVanish()
                    : pRpr.addNewVanish();
            vanishCtOnOff.setVal(STOnOff.TRUE);
        }
        // 阳文
        if (isEmboss) {
            CTOnOff embossCtOnOff = pRpr.isSetEmboss() ? pRpr.getEmboss()
                    : pRpr.addNewEmboss();
            embossCtOnOff.setVal(STOnOff.TRUE);
        }
        // 阴文
        if (isImprint) {
            CTOnOff isImprintCtOnOff = pRpr.isSetImprint() ? pRpr.getImprint()
                    : pRpr.addNewImprint();
            isImprintCtOnOff.setVal(STOnOff.TRUE);
        }
        // 空心
        if (isOutline) {
            CTOnOff isOutlineCtOnOff = pRpr.isSetOutline() ? pRpr.getOutline()
                    : pRpr.addNewOutline();
            isOutlineCtOnOff.setVal(STOnOff.TRUE);
        }
        // 着重号
        if (isEm) {
            CTEm em = pRpr.isSetEm() ? pRpr.getEm() : pRpr.addNewEm();
            em.setVal(emType);
        }
        // 设置下划线样式
        if (isUnderLine) {
            CTUnderline u = pRpr.isSetU() ? pRpr.getU() : pRpr.addNewU();
            if (underStyle != null) {
                u.setVal(underStyle);
            }
            if (underLineColor != null) {
                u.setColor(underLineColor);
            }
        }
        // 设置突出显示文本
        if (isHightLight) {
            if (hightStyle != null) {
                CTHighlight hightLight = pRpr.isSetHighlight() ? pRpr
                        .getHighlight() : pRpr.addNewHighlight();
                hightLight.setVal(hightStyle);
            }
        }
        if (isShd) {
            // 设置底纹
            CTShd shd = pRpr.isSetShd() ? pRpr.getShd() : pRpr.addNewShd();
            if (shdStyle != null) {
                shd.setVal(shdStyle);
            }
            if (shdColor != null) {
                shd.setColor(shdColor);
            }
        }
        // 上标下标
        if (verticalAlign != null) {
            pRun.setSubscript(verticalAlign);
        }
        // 设置文本位置
        pRun.setTextPosition(position);
        if (spacingValue > 0) {
            // 设置字符间距信息
            CTSignedTwipsMeasure ctSTwipsMeasure = pRpr.isSetSpacing() ? pRpr
                    .getSpacing() : pRpr.addNewSpacing();
            ctSTwipsMeasure
                    .setVal(new BigInteger(String.valueOf(spacingValue)));
        }
        if (indent > 0) {
            CTTextScale paramCTTextScale = pRpr.isSetW() ? pRpr.getW() : pRpr
                    .addNewW();
            paramCTTextScale.setVal(indent);
        }
    }

    /**
     * @Description: 设置段落底纹(对整段文字起作用)
     */
    public void setParagraphShdStyle(XWPFParagraph p, boolean isShd,
                                     STShd.Enum shdStyle, String shdColor) {
        CTPPr pPpr = getParagraphCTPPr(p);
        CTShd shd = pPpr.isSetShd() ? pPpr.getShd() : pPpr.addNewShd();
        if (shdStyle != null) {
            shd.setVal(shdStyle);
        }
        if (shdColor != null) {
            shd.setColor(shdColor);
        }
    }

    /**
     * @Description: 设置段落间距信息, 一行=100 一磅=20
     */
    public void setParagraphSpacingInfo(XWPFParagraph p, boolean isSpace,
                                        String before, String after, String beforeLines, String afterLines,
                                        boolean isLine, String line, STLineSpacingRule.Enum lineValue) {
        CTPPr pPPr = getParagraphCTPPr(p);
        CTSpacing pSpacing = pPPr.getSpacing() != null ? pPPr.getSpacing()
                : pPPr.addNewSpacing();
        if (isSpace) {
            // 段前磅数
            if (before != null) {
                pSpacing.setBefore(new BigInteger(before));
            }
            // 段后磅数
            if (after != null) {
                pSpacing.setAfter(new BigInteger(after));
            }
            // 段前行数
            if (beforeLines != null) {
                pSpacing.setBeforeLines(new BigInteger(beforeLines));
            }
            // 段后行数
            if (afterLines != null) {
                pSpacing.setAfterLines(new BigInteger(afterLines));
            }
        }
        // 间距
        if (isLine) {
            if (line != null) {
                pSpacing.setLine(new BigInteger(line));
            }
            if (lineValue != null) {
                pSpacing.setLineRule(lineValue);
            }
        }
    }

    // 设置段落缩进信息 1厘米≈567
    public void setParagraphIndInfo(XWPFParagraph p, String firstLine,
                                    String firstLineChar, String hanging, String hangingChar,
                                    String right, String rigthChar, String left, String leftChar) {
        CTPPr pPPr = getParagraphCTPPr(p);
        CTInd pInd = pPPr.getInd() != null ? pPPr.getInd() : pPPr.addNewInd();
        if (firstLine != null) {
            pInd.setFirstLine(new BigInteger(firstLine));
        }
        if (firstLineChar != null) {
            pInd.setFirstLineChars(new BigInteger(firstLineChar));
        }
        if (hanging != null) {
            pInd.setHanging(new BigInteger(hanging));
        }
        if (hangingChar != null) {
            pInd.setHangingChars(new BigInteger(hangingChar));
        }
        if (left != null) {
            pInd.setLeft(new BigInteger(left));
        }
        if (leftChar != null) {
            pInd.setLeftChars(new BigInteger(leftChar));
        }
        if (right != null) {
            pInd.setRight(new BigInteger(right));
        }
        if (rigthChar != null) {
            pInd.setRightChars(new BigInteger(rigthChar));
        }
    }

    // 设置段落边框
    public void setParagraphBorders(XWPFParagraph p, Borders lborder,
                                    Borders tBorders, Borders rBorders, Borders bBorders,
                                    Borders btborders) {
        if (lborder != null) {
            p.setBorderLeft(lborder);
        }
        if (tBorders != null) {
            p.setBorderTop(tBorders);
        }
        if (rBorders != null) {
            p.setBorderRight(rBorders);
        }
        if (bBorders != null) {
            p.setBorderBottom(bBorders);
        }
        if (btborders != null) {
            p.setBorderBetween(btborders);
        }
    }

    /**
     * @Description: 设置段落对齐
     */
    public void setParagraphAlignInfo(XWPFParagraph p,
                                      ParagraphAlignment pAlign, TextAlignment valign) {
        if (pAlign != null) {
            p.setAlignment(pAlign);
        }
        if (valign != null) {
            p.setVerticalAlignment(valign);
        }
    }

    /*------------------------------------Word 表格相关---------------------------------------------------  */

    /**
     * @Description:删除指定位置的表格,被删除表格后的索引位置--
     */
    public void deleteTableByIndex(XWPFDocument xdoc, int pos) {
        Iterator<IBodyElement> bodyElement = xdoc.getBodyElementsIterator();
        int eIndex = 0, tableIndex = -1;
        while (bodyElement.hasNext()) {
            IBodyElement element = bodyElement.next();
            BodyElementType elementType = element.getElementType();
            if (elementType == BodyElementType.TABLE) {
                tableIndex++;
                if (tableIndex == pos) {
                    break;
                }
            }
            eIndex++;
        }
        xdoc.removeBodyElement(eIndex);
    }

    public XWPFTable getTableByIndex(XWPFDocument xdoc, int index) {
        List<XWPFTable> tablesList = getAllTable(xdoc);
        if (tablesList == null || index < 0 || index > tablesList.size()) {
            return null;
        }
        return tablesList.get(index);
    }

    public List<XWPFTable> getAllTable(XWPFDocument xdoc) {
        return xdoc.getTables();
    }

    /**
     * @Description: 得到表格内容(第一次跨行单元格视为一个 ， 第二次跳过跨行合并的单元格)
     */
    public List<List<String>> getTableRContent(XWPFTable table) {
        List<List<String>> tableContentList = new ArrayList<List<String>>();
        for (int rowIndex = 0, rowLen = table.getNumberOfRows(); rowIndex < rowLen; rowIndex++) {
            XWPFTableRow row = table.getRow(rowIndex);
            List<String> cellContentList = new ArrayList<String>();
            for (int colIndex = 0, colLen = row.getTableCells().size(); colIndex < colLen; colIndex++) {
                XWPFTableCell cell = row.getCell(colIndex);
                CTTc ctTc = cell.getCTTc();
                if (ctTc.isSetTcPr()) {
                    CTTcPr tcPr = ctTc.getTcPr();
                    if (tcPr.isSetHMerge()) {
                        CTHMerge hMerge = tcPr.getHMerge();
                        if (STMerge.RESTART.equals(hMerge.getVal())) {
                            cellContentList.add(getTableCellContent(cell));
                        }
                    } else if (tcPr.isSetVMerge()) {
                        CTVMerge vMerge = tcPr.getVMerge();
                        if (STMerge.RESTART.equals(vMerge.getVal())) {
                            cellContentList.add(getTableCellContent(cell));
                        }
                    } else {
                        cellContentList.add(getTableCellContent(cell));
                    }
                }
            }
            tableContentList.add(cellContentList);
        }
        return tableContentList;
    }

    /**
     * @Description: 得到表格内容, 合并后的单元格视为一个单元格
     */
    public List<List<String>> getTableContent(XWPFTable table) {
        List<List<String>> tableContentList = new ArrayList<List<String>>();
        for (int rowIndex = 0, rowLen = table.getNumberOfRows(); rowIndex < rowLen; rowIndex++) {
            XWPFTableRow row = table.getRow(rowIndex);
            List<String> cellContentList = new ArrayList<String>();
            for (int colIndex = 0, colLen = row.getTableCells().size(); colIndex < colLen; colIndex++) {
                XWPFTableCell cell = row.getCell(colIndex);
                cellContentList.add(getTableCellContent(cell));
            }
            tableContentList.add(cellContentList);
        }
        return tableContentList;
    }

    public String getTableCellContent(XWPFTableCell cell) {
        StringBuffer sb = new StringBuffer();
        List<XWPFParagraph> cellPList = cell.getParagraphs();
        if (cellPList != null && cellPList.size() > 0) {
            for (XWPFParagraph xwpfPr : cellPList) {
                List<XWPFRun> runs = xwpfPr.getRuns();
                if (runs != null && runs.size() > 0) {
                    for (XWPFRun xwpfRun : runs) {
                        sb.append(xwpfRun.getText(0));
                    }
                }
            }
        }
        return sb.toString();
    }

    /**
     * @Description: 创建表格, 创建后表格至少有1行1列, 设置列宽
     */
    public XWPFTable createTable(XWPFDocument xdoc, int rowSize, int cellSize,
                                 boolean isSetColWidth, int[] colWidths) {
        XWPFTable table = xdoc.createTable(rowSize, cellSize);
        if (isSetColWidth) {
            CTTbl ttbl = table.getCTTbl();
            CTTblGrid tblGrid = ttbl.addNewTblGrid();
            for (int j = 0, len = Math.min(cellSize, colWidths.length); j < len; j++) {
                CTTblGridCol gridCol = tblGrid.addNewGridCol();
                gridCol.setW(new BigInteger(String.valueOf(colWidths[j])));
            }
        }
        return table;
    }

    /**
     * @Description: 设置表格总宽度与水平对齐方式
     */
    public void setTableWidthAndHAlign(XWPFTable table, String width,
                                       STJc.Enum enumValue) {
        CTTblPr tblPr = getTableCTTblPr(table);
        CTTblWidth tblWidth = tblPr.isSetTblW() ? tblPr.getTblW() : tblPr
                .addNewTblW();
        if (enumValue != null) {
            CTJc cTJc = tblPr.addNewJc();
            cTJc.setVal(enumValue);
        }
        tblWidth.setW(new BigInteger(width));
        tblWidth.setType(STTblWidth.DXA);
    }

    /**
     * @Description: 得到Table的CTTblPr, 不存在则新建
     */
    public CTTblPr getTableCTTblPr(XWPFTable table) {
        CTTbl ttbl = table.getCTTbl();
        CTTblPr tblPr = ttbl.getTblPr() == null ? ttbl.addNewTblPr() : ttbl
                .getTblPr();
        return tblPr;
    }

    /**
     * @Description: 得到Table的边框, 不存在则新建
     */
    public CTTblBorders getTableBorders(XWPFTable table) {
        CTTblPr tblPr = getTableCTTblPr(table);
        CTTblBorders tblBorders = tblPr.isSetTblBorders() ? tblPr
                .getTblBorders() : tblPr.addNewTblBorders();
        return tblBorders;
    }

    /**
     * @Description: 设置表格边框样式
     */
    public void setTableBorders(XWPFTable table, CTBorder left, CTBorder top,
                                CTBorder right, CTBorder bottom) {
        CTTblBorders tblBorders = getTableBorders(table);
        if (left != null) {
            tblBorders.setLeft(left);
        }
        if (top != null) {
            tblBorders.setTop(top);
        }
        if (right != null) {
            tblBorders.setRight(right);
        }
        if (bottom != null) {
            tblBorders.setBottom(bottom);
        }
    }

    /**
     * @Description: 表格指定位置插入一行, index为新增行所在的行位置(不能大于表行数)
     */
    public void insertTableRowAtIndex(XWPFTable table, int index) {
        XWPFTableRow firstRow = table.getRow(0);
        XWPFTableRow row = table.insertNewTableRow(index);
        if (row == null) {
            return;
        }
        CTTbl ctTbl = table.getCTTbl();
        CTTblGrid tblGrid = ctTbl.getTblGrid();
        int cellSize = 0;
        boolean isAdd = false;
        if (tblGrid != null) {
            List<CTTblGridCol> gridColList = tblGrid.getGridColList();
            if (gridColList != null && gridColList.size() > 0) {
                isAdd = true;
                for (CTTblGridCol ctlCol : gridColList) {
                    XWPFTableCell cell = row.addNewTableCell();
                    setCellWidthAndVAlign(cell, ctlCol.getW().toString(),
                            STTblWidth.DXA, null);
                }
            }
        }
        // 大部分都不会走到这一步
        if (!isAdd) {
            cellSize = getCellSizeWithMergeNum(firstRow);
            for (int i = 0; i < cellSize; i++) {
                row.addNewTableCell();
            }
        }
    }

    /**
     * @Description: 删除表一行
     */
    public void deleteTableRow(XWPFTable table, int index) {
        table.removeRow(index);
    }

    /**
     * @Description: 统计列数(包括合并的列数)
     */
    public int getCellSizeWithMergeNum(XWPFTableRow row) {
        List<XWPFTableCell> firstRowCellList = row.getTableCells();
        int cellSize = firstRowCellList.size();
        for (XWPFTableCell xwpfTableCell : firstRowCellList) {
            CTTc ctTc = xwpfTableCell.getCTTc();
            if (ctTc.isSetTcPr()) {
                CTTcPr tcPr = ctTc.getTcPr();
                if (tcPr.isSetGridSpan()) {
                    CTDecimalNumber gridSpan = tcPr.getGridSpan();
                    cellSize += gridSpan.getVal().intValue() - 1;
                }
            }
        }
        return cellSize;
    }

    /**
     * @Description: 得到CTTrPr, 不存在则新建
     */
    public CTTrPr getRowCTTrPr(XWPFTableRow row) {
        CTRow ctRow = row.getCtRow();
        CTTrPr trPr = ctRow.isSetTrPr() ? ctRow.getTrPr() : ctRow.addNewTrPr();
        return trPr;
    }

    /**
     * @Description: 设置行高
     */
    public void setRowHeight(XWPFTableRow row, String hight,
                             STHeightRule.Enum heigthEnum) {
        CTTrPr trPr = getRowCTTrPr(row);
        CTHeight trHeight;
        if (trPr.getTrHeightList() != null && trPr.getTrHeightList().size() > 0) {
            trHeight = trPr.getTrHeightList().get(0);
        } else {
            trHeight = trPr.addNewTrHeight();
        }
        trHeight.setVal(new BigInteger(hight));
        if (heigthEnum != null) {
            trHeight.setHRule(heigthEnum);
        }
    }

    /**
     * @Description: 隐藏行
     */
    public void setRowHidden(XWPFTableRow row, boolean hidden) {
        CTTrPr trPr = getRowCTTrPr(row);
        CTOnOff hiddenValue;
        if (trPr.getHiddenList() != null && trPr.getHiddenList().size() > 0) {
            hiddenValue = trPr.getHiddenList().get(0);
        } else {
            hiddenValue = trPr.addNewHidden();
        }
        if (hidden) {
            hiddenValue.setVal(STOnOff.TRUE);
        } else {
            hiddenValue.setVal(STOnOff.FALSE);
        }
        setRowAllCellHidden(row, hidden);
    }

    public void setRowAllCellHidden(XWPFTableRow row, boolean isVanish) {
        for (int colIndex = 0, colLen = row.getTableCells().size(); colIndex < colLen; colIndex++) {
            XWPFTableCell cell = row.getCell(colIndex);
            setCellHidden(cell, isVanish);
        }
    }

    /**
     * @Description: 设置单元格内容
     */
    public void setCellNewContent(XWPFTable table, int rowIndex, int col, String content) {
        XWPFTableCell cell = table.getRow(rowIndex).getCell(col);
        XWPFParagraph p = getCellFirstParagraph(cell);
        List<XWPFRun> cellRunList = p.getRuns();
        if (cellRunList == null || cellRunList.size() == 0) {
            return;
        }
        for (int i = cellRunList.size() - 1; i >= 1; i--) {
            p.removeRun(i);
        }
        XWPFRun run = cellRunList.get(0);
        run.setText(content);
    }

    /**
     * @Description: 删除单元格内容
     */
    public void deleteCellContent(XWPFTable table, int rowIndex, int col) {
        XWPFTableCell cell = table.getRow(rowIndex).getCell(col);
        XWPFParagraph p = getCellFirstParagraph(cell);
        List<XWPFRun> cellRunList = p.getRuns();
        if (cellRunList == null || cellRunList.size() == 0) {
            return;
        }
        for (int i = cellRunList.size() - 1; i >= 0; i--) {
            p.removeRun(i);
        }
    }

    /**
     * @Description: 隐藏单元格内容
     */
    public void setHiddenCellContent(XWPFTable table, int rowIndex, int col) {
        XWPFTableCell cell = table.getRow(rowIndex).getCell(col);
        setCellHidden(cell, true);
    }

    public void setCellHidden(XWPFTableCell cell, boolean isVanish) {
        XWPFParagraph p = getCellFirstParagraph(cell);
        CTPPr pPPr = getParagraphCTPPr(p);
        CTParaRPr paRpr = pPPr.isSetRPr() ? pPPr.getRPr() : pPPr.addNewRPr();
        CTOnOff vanishCtOnOff = paRpr.isSetVanish() ? paRpr.getVanish() : paRpr
                .addNewVanish();
        if (isVanish) {
            vanishCtOnOff.setVal(STOnOff.TRUE);
        } else {
            vanishCtOnOff.setVal(STOnOff.FALSE);
        }
        List<XWPFRun> cellRunList = p.getRuns();
        if (cellRunList == null || cellRunList.size() == 0) {
            return;
        }
        for (XWPFRun xwpfRun : cellRunList) {
            CTRPr pRpr = getRunCTRPr(p, xwpfRun);
            vanishCtOnOff = pRpr.isSetVanish() ? pRpr.getVanish() : pRpr
                    .addNewVanish();
            if (isVanish) {
                vanishCtOnOff.setVal(STOnOff.TRUE);
            } else {
                vanishCtOnOff.setVal(STOnOff.FALSE);
            }
        }
    }

    /**
     * @Description: 得到Cell的CTTcPr, 不存在则新建
     */
    public CTTcPr getCellCTTcPr(XWPFTableCell cell) {
        CTTc cttc = cell.getCTTc();
        CTTcPr tcPr = cttc.isSetTcPr() ? cttc.getTcPr() : cttc.addNewTcPr();
        return tcPr;
    }

    /**
     * @Description: 设置垂直对齐方式
     */
    public void setCellVAlign(XWPFTableCell cell, STVerticalJc.Enum vAlign) {
        setCellWidthAndVAlign(cell, null, null, vAlign);
    }

    /**
     * @Description: 设置列宽和垂直对齐方式
     */
    public void setCellWidthAndVAlign(XWPFTableCell cell, String width,
                                      STTblWidth.Enum typeEnum, STVerticalJc.Enum vAlign) {
        CTTcPr tcPr = getCellCTTcPr(cell);
        CTTblWidth tcw = tcPr.isSetTcW() ? tcPr.getTcW() : tcPr.addNewTcW();
        if (width != null) {
            tcw.setW(new BigInteger(width));
        }
        if (typeEnum != null) {
            tcw.setType(typeEnum);
        }
        if (vAlign != null) {
            CTVerticalJc vJc = tcPr.isSetVAlign() ? tcPr.getVAlign() : tcPr
                    .addNewVAlign();
            vJc.setVal(vAlign);
        }
    }

    /**
     * @Description: 得到单元格第一个Paragraph
     */
    public XWPFParagraph getCellFirstParagraph(XWPFTableCell cell) {
        XWPFParagraph p;
        if (cell.getParagraphs() != null && cell.getParagraphs().size() > 0) {
            p = cell.getParagraphs().get(0);
        } else {
            p = cell.addParagraph();
        }
        return p;
    }

    /**
     * @Description: 跨列合并
     */
    public void mergeCellsHorizontal(XWPFTable table, int row, int fromCell,
                                     int toCell) {
        for (int cellIndex = fromCell; cellIndex <= toCell; cellIndex++) {
            XWPFTableCell cell = table.getRow(row).getCell(cellIndex);
            if (cellIndex == fromCell) {
                // The first merged cell is set with RESTART merge value
                getCellCTTcPr(cell).addNewHMerge().setVal(STMerge.RESTART);
            } else {
                // Cells which join (merge) the first one,are set with CONTINUE
                getCellCTTcPr(cell).addNewHMerge().setVal(STMerge.CONTINUE);
            }
        }
    }

    /**
     * @Description: 跨行合并
     * //     * @see http://stackoverflow.com/questions/24907541/row-span-with-xwpftable
     */
    public void mergeCellsVertically(XWPFTable table, int col, int fromRow,
                                     int toRow) {
        for (int rowIndex = fromRow; rowIndex <= toRow; rowIndex++) {
            XWPFTableCell cell = table.getRow(rowIndex).getCell(col);
            if (rowIndex == fromRow) {
                // The first merged cell is set with RESTART merge value
                getCellCTTcPr(cell).addNewVMerge().setVal(STMerge.RESTART);
            } else {
                // Cells which join (merge) the first one,are set with CONTINUE
                getCellCTTcPr(cell).addNewVMerge().setVal(STMerge.CONTINUE);
            }
        }
    }

    /*------------------------------------Word 文档信息---------------------------------------------------  */

    /**
     * @Description: 设置页面背景色
     */
    public void setDocumentbackground(XWPFDocument document, String bgColor) {
        CTBackground bg = document.getDocument().isSetBackground() ? document
                .getDocument().getBackground() : document.getDocument()
                .addNewBackground();
        bg.setColor(bgColor);
    }

    public CTSectPr getDocumentCTSectPr(XWPFDocument document) {
        CTSectPr sectPr = document.getDocument().getBody().isSetSectPr() ? document
                .getDocument().getBody().getSectPr()
                : document.getDocument().getBody().addNewSectPr();
        return sectPr;
    }

    /**
     * @Description: 页面Break
     */
    public void addNewPageBreak(XWPFDocument document, BreakType breakType) {
        XWPFParagraph xp = document.createParagraph();
        xp.createRun().addBreak(breakType);
    }

    /**
     * @Description: 设置页面边框
     */
    public void setPgBorders(XWPFDocument document, CTBorder top,
                             CTBorder right, CTBorder bottom, CTBorder left) {
        CTSectPr sectPr = getDocumentCTSectPr(document);
        CTPageBorders pd = sectPr.isSetPgBorders() ? sectPr.getPgBorders()
                : sectPr.addNewPgBorders();
        /*
         * CTBorder bb = pd.addNewBottom(); bb.setVal(STBorder.SINGLE);
         * bb.setSz(new BigInteger("4")); bb.setSpace(new BigInteger("24"));
         * bb.setColor("FBB61F");
         */
        if (top != null) {
            pd.setTop(top);
        }
        if (right != null) {
            pd.setRight(right);
        }
        if (bottom != null) {
            pd.setBottom(bottom);
        }
        if (left != null) {
            pd.setLeft(left);
        }
    }

    /**
     * @Description: 设置页面大小及纸张方向 landscape横向
     */
    public void setDocumentSize(XWPFDocument document, String width,
                                String height, STPageOrientation.Enum stValue) {
        CTSectPr sectPr = getDocumentCTSectPr(document);
        CTPageSz pgsz = sectPr.isSetPgSz() ? sectPr.getPgSz() : sectPr
                .addNewPgSz();
        pgsz.setH(new BigInteger(height));
        pgsz.setW(new BigInteger(width));
        pgsz.setOrient(stValue);
    }

    /**
     * @Description: 设置页边距 (word中1厘米约等于567)
     */
    public void setDocumentMargin(XWPFDocument document, String left,
                                  String top, String right, String bottom) {
        CTSectPr sectPr = getDocumentCTSectPr(document);
        CTPageMar ctpagemar = sectPr.addNewPgMar();
        if (StringUtils.isNotBlank(left)) {
            ctpagemar.setLeft(new BigInteger(left));
        }
        if (StringUtils.isNotBlank(top)) {
            ctpagemar.setTop(new BigInteger(top));
        }
        if (StringUtils.isNotBlank(right)) {
            ctpagemar.setRight(new BigInteger(right));
        }
        if (StringUtils.isNotBlank(bottom)) {
            ctpagemar.setBottom(new BigInteger(bottom));
        }
    }

    /**
     * @Description: 保存文档
     */
    public void saveDocument(XWPFDocument document, String savePath)
            throws Exception {
        FileOutputStream fos = new FileOutputStream(savePath);
        document.write(fos);
        fos.close();
    }

    /**
     * @Description: 打开word文档
     */
    public XWPFDocument openDocument(String filePath) throws Exception {
        XWPFDocument xdoc = new XWPFDocument(
                POIXMLDocument.openPackage(filePath));
        return xdoc;
    }


    public static void main(String[] args) throws Exception {
        WordCommonUtils t = new WordCommonUtils();
        CustomXWPFDocument_S_9 xdoc = new CustomXWPFDocument_S_9();
        t.testCreateDocumentStyle(xdoc);
        t.testAddHeaderFooter(xdoc);
        t.testCreateSimpleParagraph(xdoc);
        t.addNewPageBreak(xdoc, BreakType.TEXT_WRAPPING);
        t.testCreateParagraphWithImg(xdoc);
        t.addNewPageBreak(xdoc, BreakType.TEXT_WRAPPING);
        t.testCreateParagraphWithHyLink(xdoc);
        t.addNewPageBreak(xdoc, BreakType.TEXT_WRAPPING);
        t.testCreateParagraphWithBookMark(xdoc);
        t.addNewPageBreak(xdoc, BreakType.TEXT_WRAPPING);
        t.testCreateTable(xdoc);
        t.addNewPageBreak(xdoc, BreakType.TEXT_WRAPPING);
        String filePath = "f:/saveFile/temp/sys_" + System.currentTimeMillis()
                + ".docx";
        t.saveDocument(xdoc, filePath);
        XWPFDocument xdoc2 = t.openDocument(filePath);
        XWPFTable table = t.getTableByIndex(xdoc2, 0);
        List<List<String>> tableList = t.getTableRContent(table);
        for (List<String> list : tableList) {
            System.out.println(list);
        }
        XWPFDocument xdoc21 = t
                .openDocument("f:/saveFile/temp/sys_1423892350239.docx");
        XWPFTable table1 = t.getTableByIndex(xdoc2, 0);
        List<List<String>> tableList1 = t.getTableRContent(table);
        for (List<String> list : tableList) {
            System.out.println(list);
        }
        t.insertTableRowAtIndex(table, 3);
        t.deleteTableRow(table, 4);
        t.deleteTableRow(table, 3);
        t.setCellNewContent(table, 0, 0, "新内容");
        t.deleteCellContent(table, 1, 0);
        t.setHiddenCellContent(table, 2, 1);
        t.deleteTableByIndex(xdoc2, 1);
        t.saveDocument(xdoc2,
                "f:/saveFile/temp/sys_" + System.currentTimeMillis() + ".docx");
    }

    public void testCreateTable(XWPFDocument xdoc) {
        int[] colWidthArr = new int[]{1500, 3000, 1200, 850, 600, 850};
        XWPFTable table = createTable(xdoc, 8, 6, true, colWidthArr);
        setTableWidthAndHAlign(table, "8000", STJc.CENTER);
        CTTblBorders tblBorders = getTableBorders(table);
        CTBorder rBorder = tblBorders.addNewTop();
        rBorder.setVal(STBorder.SINGLE);
        rBorder.setSz(new BigInteger("3"));
        rBorder.setColor("BF9C9C");
        CTBorder lBorder = tblBorders.addNewLeft();
        lBorder.setVal(STBorder.NONE);

        setTableBorders(table, lBorder, rBorder, lBorder, rBorder);
        testFillTableValue(table);
        mergeCellsVertically(table, 1, 1, 4);
        mergeCellsVertically(table, 4, 2, 4);
        mergeCellsHorizontal(table, 0, 3, 5);
        mergeCellsHorizontal(table, 2, 2, 3);
    }

    public void testFillTableValue(XWPFTable table) {
        for (int rowIndex = 0, rowLen = table.getNumberOfRows(); rowIndex < rowLen; rowIndex++) {
            XWPFTableRow row = table.getRow(rowIndex);
            if (rowIndex == rowLen - 4) {
                setRowHeight(row, "-1", null);//不可见
            } else {
                setRowHeight(row, "480", null);
            }
            for (int colIndex = 0; colIndex < row.getTableCells().size(); colIndex++) {
                XWPFTableCell cell = row.getCell(colIndex);
                setCellVAlign(cell, STVerticalJc.CENTER);
                XWPFParagraph p = getCellFirstParagraph(cell);
                XWPFRun pRun = getOrAddParagraphFirstRun(p, false, false);
                setParagraphRunFontInfo(p, pRun, rowIndex + "_单元格_" + colIndex,
                        "微软雅黑", "22");
                setParagraphTextBasicStyleInfo(p, pRun, null, false, false,
                        null, null, true, false, false, null, true,
                        STShd.HORZ_STRIPE, "F3C917");
                setParagraphAlignInfo(p, ParagraphAlignment.CENTER, null);
            }
            if (rowIndex == rowLen - 2) {
                setRowHidden(row, true);
            }
        }
    }

    public void testAddHeaderFooter(XWPFDocument doc) throws Exception {
        simpleDateHeader(doc);
        simpleNumberFooter(doc);
    }

    public void testCreateDocumentStyle(XWPFDocument xdoc) {
        // 设置文档背景
        setDocumentbackground(xdoc, "E1E6F6");

        // 设置文档边框
        CTSectPr sectPr = getDocumentCTSectPr(xdoc);
        CTPageBorders pd = sectPr.isSetPgBorders() ? sectPr.getPgBorders()
                : sectPr.addNewPgBorders();
        CTBorder bd = pd.addNewBottom();
        bd.setVal(STBorder.SINGLE);
        bd.setSz(new BigInteger("4"));
        bd.setSpace(new BigInteger("24"));
        bd.setColor("FBB61F");

        setPgBorders(xdoc, bd, bd, bd, bd);
        setDocumentMargin(xdoc, "1797", "1440", "1797", "1440");
    }

    // 测试带书签文本
    public void testCreateParagraphWithBookMark(XWPFDocument xdoc) {
        XWPFParagraph p = xdoc.createParagraph();
        setParagraphAlignInfo(p, ParagraphAlignment.LEFT, TextAlignment.CENTER);
        setParagraphSpacingInfo(p, true, "0", "0", "0", "0", true, "240",
                STLineSpacingRule.AUTO);
        BigInteger markId = BigInteger.valueOf(1);
        addParagraphContentBookmarkBasicStyle(p, "测试", markId, "书签一", false,
                false, "微软雅黑", "24", null, false, false, null, null, false,
                false);
        markId = markId.add(BigInteger.ONE);
        addParagraphContentBookmarkBasicStyle(p, "书签", markId, "书签二", true,
                false, "微软雅黑", "24", null, false, false, null, null, false,
                false);
    }

    // 测试带超链接段落
    public void testCreateParagraphWithHyLink(XWPFDocument xdoc) {
        XWPFParagraph p = xdoc.createParagraph();
        setParagraphAlignInfo(p, ParagraphAlignment.LEFT, TextAlignment.CENTER);
        setParagraphSpacingInfo(p, true, "0", "0", "0", "0", true, "240",
                STLineSpacingRule.AUTO);
        XWPFRun pRun = getOrAddParagraphFirstRun(p, false, false);
        setParagraphRunFontInfo(p, pRun, "测试", "宋体", "22");
        addParagraphTextHyperlinkBasicStyle(p,
                "mailto:123@qq.com?subject=测试poi超链接", "超链接", "黑体", "22",
                "0000FF", true, true, false);
        pRun = getOrAddParagraphFirstRun(p, true, false);
        setParagraphRunFontInfo(p, pRun, "其他文本", "宋体", "22");
    }

    // 测试简单文本段落
    public void testCreateSimpleParagraph(XWPFDocument xdoc) {
        XWPFParagraph p = xdoc.createParagraph();
        setParagraphAlignInfo(p, ParagraphAlignment.CENTER,
                TextAlignment.CENTER);
        setParagraphBorders(p, Borders.NONE, Borders.NONE, Borders.NONE,
                Borders.SINGLE, null);
        XWPFRun pRun = getOrAddParagraphFirstRun(p, false, false);
        setParagraphTextSimpleStyleInfo(p, pRun, null, true, true, "FFA932",
                STUnderline.DASH, true, false, true,
                STHighlightColor.DARK_YELLOW, false, null, null, null, 0, 0, 0);
        setParagraphSpacingInfo(p, true, "0", "0", "0", "0", true, "240",
                STLineSpacingRule.AUTO);
        setParagraphRunFontInfo(p, pRun, "测试段落下边框下划线高亮显示文本", "微软雅黑", "22");
        pRun = getOrAddParagraphFirstRun(p, true, false);
        setParagraphRunFontInfo(p, pRun, "继续添加文本", "黑体", "26");
        pRun = getOrAddParagraphFirstRun(p, true, false);
        setParagraphRunFontInfo(p, pRun, "继续文本测试底纹", "宋体", "22");
        setParagraphTextBasicStyleInfo(p, pRun, null, false, false, null, null,
                true, false, false, null, true, STShd.HORZ_STRIPE, "F3C917");
        pRun = getOrAddParagraphFirstRun(p, true, false);
        setParagraphRunFontInfo(p, pRun, "测", "宋体", "22");
        setParagraphTextSimpleStyleInfo(p, pRun, null, false, false, null,
                null, true, false, false, null, false, null, null, null, 6, 80,
                0);
        pRun = getOrAddParagraphFirstRun(p, true, false);
        setParagraphRunFontInfo(p, pRun, "上标", "宋体", "22");
        setParagraphTextSimpleStyleInfo(p, pRun, null, false, false, null,
                null, true, false, false, null, false, null, null,
                VerticalAlign.SUPERSCRIPT, 0, 0, 0);
        pRun = getOrAddParagraphFirstRun(p, true, false);
        setParagraphRunFontInfo(p, pRun, "下标", "宋体", "22");
        setParagraphTextSimpleStyleInfo(p, pRun, null, false, false, null,
                null, true, false, false, null, false, null, null,
                VerticalAlign.SUBSCRIPT, 0, 0, 0);
        pRun = getOrAddParagraphFirstRun(p, true, false);
        setParagraphRunFontInfo(p, pRun, "继续添加文本把段落内容挤下去", "宋体", "22");
        setParagraphTextBasicStyleInfo(p, pRun, null, false, false, null, null,
                true, false, false, null, false, null, null);
        pRun = getOrAddParagraphFirstRun(p, true, true);
        setParagraphRunFontInfo(p, pRun, "测试换行", "宋体", "22");
        setParagraphTextBasicStyleInfo(p, pRun, null, false, false, null, null,
                true, false, false, null, false, null, null);
        p = xdoc.createParagraph();
        setParagraphAlignInfo(p, ParagraphAlignment.LEFT, TextAlignment.CENTER);
        pRun = getOrAddParagraphFirstRun(p, false, false);
        setParagraphRunFontInfo(p, pRun, "新增一段测试段落底纹", "宋体", "22");
        setParagraphShdStyle(p, true, STShd.REVERSE_DIAG_STRIPE, "DD999D");
        setParagraphSpacingInfo(p, true, "0", "0", "200", "200", true, "240",
                STLineSpacingRule.AUTO);
    }

    // 测试带图片段落
    public void testCreateParagraphWithImg(CustomXWPFDocument_S_9 xdoc)
            throws Exception {
        XWPFParagraph p = xdoc.createParagraph();
        setParagraphAlignInfo(p, ParagraphAlignment.LEFT, TextAlignment.CENTER);
        setParagraphSpacingInfo(p, true, "0", "0", "0", "0", true, "240",
                STLineSpacingRule.AUTO);
        XWPFRun pRun = getOrAddParagraphFirstRun(p, false, false);
        setParagraphRunFontInfo(p, pRun, "1.下列实验操作中，正确的是(    ) ", "宋体", "22");
        pRun = getOrAddParagraphFirstRun(p, true, true);
        setParagraphRunFontInfo(p, pRun, "A", "宋体", "22");
        String blipId = p.getDocument().addPictureData(
                new FileInputStream(new File("f:/saveFile/temp/image1.png")),
                Document.PICTURE_TYPE_PNG);
        xdoc.createPicture(blipId,
                xdoc.getNextPicNameNumber(Document.PICTURE_TYPE_PNG), 90, 93, p);
        pRun = getOrAddParagraphFirstRun(p, true, false);
        setParagraphRunFontInfo(p, pRun, StringUtils.leftPad("B.", 10), "宋体",
                "22");
        blipId = p.getDocument().addPictureData(
                new FileInputStream(new File("f:/saveFile/temp/image2.png")),
                Document.PICTURE_TYPE_PNG);
        xdoc.createPicture(blipId,
                xdoc.getNextPicNameNumber(Document.PICTURE_TYPE_PNG), 90, 93, p);
        pRun = getOrAddParagraphFirstRun(p, true, true);
        setParagraphRunFontInfo(p, pRun, "C", "宋体", "22");
        blipId = p.getDocument().addPictureData(
                new FileInputStream(new File("f:/saveFile/temp/image3.png")),
                Document.PICTURE_TYPE_PNG);
        xdoc.createPicture(blipId,
                xdoc.getNextPicNameNumber(Document.PICTURE_TYPE_PNG), 90, 93, p);
        pRun = getOrAddParagraphFirstRun(p, true, false);
        setParagraphRunFontInfo(p, pRun, StringUtils.leftPad("D.", 10), "宋体",
                "22");
        blipId = p.getDocument().addPictureData(
                new FileInputStream(new File("f:/saveFile/temp/image4.png")),
                Document.PICTURE_TYPE_PNG);
        xdoc.createPicture(blipId,
                xdoc.getNextPicNameNumber(Document.PICTURE_TYPE_PNG), 90, 93, p);
    }
}

