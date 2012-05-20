InverseFizzBuzz を解いてみよう
===============
## InverseFizzBuzz について
原文
http://www.jasq.org/2/post/2012/05/inverse-fizzbuzz.html

日本語訳
http://d.hatena.ne.jp/matarillo/20120515/p1

コードゴルフ
http://golf.shinh.org/p.rb?Invert+FizzBuzz

## スライド
（発表時、複数のスライドが非表示になっていたようです。発表を聞いていただいた方、わかりにくくなってしまって申し訳ありません）

http://www.slideshare.net/HiroSuga/20120519-inverse-fizzbuzz

## Inverse FizzBuzz チェックリスト
できた！と思ったそのあとに・・・以下のことをチェックしてみましょう。

* 最短の列を返すか？
    * { Fizz, Buzz } を与えた時に長さ2の列が返るか？
* 解のない FizzBuzz 列を与えた時、クラッシュしないか？
    * { Buzz,Buzz,Buzz } を与えてもクラッシュしないか？
* 空の列（Nil）を与えた時、クラッシュしないか？正しい結果が返るか？
    * 正しい結果は、List(1) or List(2) or List(4) or etc...
* 長いFizzBuzz列に対しても、解を与えるか？
    * 長さが8以上のFizzBuzz列を与えても正しい答えを返すか？ 


Let's solve Inverse FizzBuzz!