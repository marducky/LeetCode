package tools.smillTools;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/04/25 17:06
 **/
public class GsonFormatTest {

    /**
     * TalkAgentResponse : {"@SCI":"@ae388bee-cf77-0a9e-2b1a-2ece4b16449c@49cb1aef-9322-4e8b-9744-06076d25e1d7","@IID":"e7a29567-a153-4bdc-bc32-07a3367af040","@TimeStamp":"2018-01-09T05:17:22.1553474Z","@ResponseCode":"Found","@Version":"6","Display":{"OutText":{"#text":"I'm here to help you with any questions you might have about our site/services. &nbsp;"},"AlternateOutText2":{"#text":"I'm here to help you with any questions you might have about our site/services.  "}},"nleResults":[{"confidence":62,"concepts":[{"name":"Intent","value":"4862030411967123322","friendlyName":null,"literal":"Hi, I\u2019m Nina your virtual assistant. How can I help you?"}]}]}
     */

    private TalkAgentResponseBean TalkAgentResponse;

    public TalkAgentResponseBean getTalkAgentResponse() {
        return TalkAgentResponse;
    }

    public void setTalkAgentResponse(TalkAgentResponseBean TalkAgentResponse) {
        this.TalkAgentResponse = TalkAgentResponse;
    }

    public static class TalkAgentResponseBean {
        @SerializedName("@SCI")
        private String _$SCI2; // FIXME check this code
        @SerializedName("@IID")
        private String _$IID110; // FIXME check this code
        @SerializedName("@TimeStamp")
        private String _$TimeStamp306; // FIXME check this code
        @SerializedName("@ResponseCode")
        private String _$ResponseCode246; // FIXME check this code
        @SerializedName("@Version")
        private String _$Version257; // FIXME check this code
        private DisplayBean Display;
        private List<NleResultsBean> nleResults;

        public String get_$SCI2() {
            return _$SCI2;
        }

        public void set_$SCI2(String _$SCI2) {
            this._$SCI2 = _$SCI2;
        }

        public String get_$IID110() {
            return _$IID110;
        }

        public void set_$IID110(String _$IID110) {
            this._$IID110 = _$IID110;
        }

        public String get_$TimeStamp306() {
            return _$TimeStamp306;
        }

        public void set_$TimeStamp306(String _$TimeStamp306) {
            this._$TimeStamp306 = _$TimeStamp306;
        }

        public String get_$ResponseCode246() {
            return _$ResponseCode246;
        }

        public void set_$ResponseCode246(String _$ResponseCode246) {
            this._$ResponseCode246 = _$ResponseCode246;
        }

        public String get_$Version257() {
            return _$Version257;
        }

        public void set_$Version257(String _$Version257) {
            this._$Version257 = _$Version257;
        }

        public DisplayBean getDisplay() {
            return Display;
        }

        public void setDisplay(DisplayBean Display) {
            this.Display = Display;
        }

        public List<NleResultsBean> getNleResults() {
            return nleResults;
        }

        public void setNleResults(List<NleResultsBean> nleResults) {
            this.nleResults = nleResults;
        }

        public static class DisplayBean {
            /**
             * OutText : {"#text":"I'm here to help you with any questions you might have about our site/services. &nbsp;"}
             * AlternateOutText2 : {"#text":"I'm here to help you with any questions you might have about our site/services.  "}
             */

            private OutTextBean OutText;
            private AlternateOutText2Bean AlternateOutText2;

            public OutTextBean getOutText() {
                return OutText;
            }

            public void setOutText(OutTextBean OutText) {
                this.OutText = OutText;
            }

            public AlternateOutText2Bean getAlternateOutText2() {
                return AlternateOutText2;
            }

            public void setAlternateOutText2(AlternateOutText2Bean AlternateOutText2) {
                this.AlternateOutText2 = AlternateOutText2;
            }

            public static class OutTextBean {
                @SerializedName("#text")
                private String _$Text180; // FIXME check this code

                public String get_$Text180() {
                    return _$Text180;
                }

                public void set_$Text180(String _$Text180) {
                    this._$Text180 = _$Text180;
                }
            }

            public static class AlternateOutText2Bean {
                @SerializedName("#text")
                private String _$Text194; // FIXME check this code

                public String get_$Text194() {
                    return _$Text194;
                }

                public void set_$Text194(String _$Text194) {
                    this._$Text194 = _$Text194;
                }
            }
        }

        public static class NleResultsBean {
            /**
             * confidence : 62
             * concepts : [{"name":"Intent","value":"4862030411967123322","friendlyName":null,"literal":"Hi, I\u2019m Nina your virtual assistant. How can I help you?"}]
             */

            private int confidence;
            private List<ConceptsBean> concepts;

            public int getConfidence() {
                return confidence;
            }

            public void setConfidence(int confidence) {
                this.confidence = confidence;
            }

            public List<ConceptsBean> getConcepts() {
                return concepts;
            }

            public void setConcepts(List<ConceptsBean> concepts) {
                this.concepts = concepts;
            }

            public static class ConceptsBean {
                /**
                 * name : Intent
                 * value : 4862030411967123322
                 * friendlyName : null
                 * literal : Hi, I’m Nina your virtual assistant. How can I help you?
                 */

                private String name;
                private String value;
                private Object friendlyName;
                private String literal;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }

                public Object getFriendlyName() {
                    return friendlyName;
                }

                public void setFriendlyName(Object friendlyName) {
                    this.friendlyName = friendlyName;
                }

                public String getLiteral() {
                    return literal;
                }

                public void setLiteral(String literal) {
                    this.literal = literal;
                }
            }
        }
    }
}
