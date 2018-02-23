cur_date="`date +%Y-%m-%d-%H-%m-%s`"
echo $cur_date
cat ~/.bash_history >> _history${cur_date}.txt

