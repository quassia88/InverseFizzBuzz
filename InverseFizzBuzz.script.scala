/** Inverse FizzBuzz */ 
// http://www.jasq.org/2/post/2012/05/inverse-fizzbuzz.html 

def nearestNumber(satisfies:Int => Boolean,next:Int => Int,start:Int):Int = 
  if(satisfies(start)) start else nearestNumber(satisfies,next,next(start)) 

def inverseMapOfFB(str:String):Int => Int = str match { 
  case "fizz" => nearestNumber(x=> x%3==0 && x%5!=0 && x >= 3, _+1, _) 
  case "buzz" => nearestNumber(x=> x%5==0 && x%3!=0 && x >= 5, _+1, _) 
  case "fizzbuzz" => nearestNumber(x=> x%15==0 && x >= 15, _+1, _) 
} 

def chainSeq(start:Int,funcs:List[Int=>Int]):List[Int] = funcs match { 
  case Nil => Nil 
  case _ => funcs.head(start) :: chainSeq(funcs.head(start)+1,funcs.tail) 
} 

def contiguousSeq(xs:List[Int]):List[Int]=xs match { 
  case Nil => Nil 
  case _ => (xs.head to xs.last).toList 
} 

def circleSeq(pattern:List[String],times:Int):List[String] = times match { 
  case x if x <= 0 => Nil 
  case _ => pattern ::: circleSeq(pattern,times-1) 
} 

def lookUpPattern(base:Seq[String],target:Seq[String]) = { 
  val indexes = for(
    i <- 0 until (base.size-target.size);
    val index = base.drop(i).indexOfSlice(target) if index >=0
  ) yield {index + i} 
  indexes.distinct 
} 

def shortestSeq(xss:Traversable[Traversable[Int]]) = xss match { 
  case Nil => None 
  case _ => Some(xss.minBy(_.size))
}

val fizzBuzzPattern = List("fizz", "buzz", "fizz", "fizz", "buzz", "fizz","fizzbuzz") 

def inverseFizzBuzz(strs:List[String]):Option[Traversable[Int]] = {
  if(strs.isEmpty)return Some(Seq(1))
  
  val basePattern = circleSeq(fizzBuzzPattern,strs.size/fizzBuzzPattern.size + 2) 
  val indexes = lookUpPattern(basePattern,strs) 
  shortestSeq(indexes.map(index => contiguousSeq( chainSeq(3,basePattern.map(inverseMapOfFB)).slice(index,index + strs.size) ))) 
} 

inverseFizzBuzz(Nil) //1
inverseFizzBuzz(List("fizz")) //3 
inverseFizzBuzz(List("buzz")) //5 
inverseFizzBuzz(List("fizz","buzz")) //9,10 
inverseFizzBuzz(List("buzz","fizz")) //5,6 
inverseFizzBuzz(List("fizz","buzz","fizz")) //3,4,5,6 
inverseFizzBuzz(List("fizz","fizz")) //6,7,8,9 
inverseFizzBuzz(List("fizz","fizz","buzz")) //6,7,8,9,10 
inverseFizzBuzz(List("buzz","fizz","fizzbuzz")) //10,11,12,13,14,15 
inverseFizzBuzz(List("fizzbuzz", "fizz", "buzz", "fizz", "fizz", "buzz", "fizz","fizzbuzz", "fizz", "buzz", "fizz", "fizz", "buzz", "fizz" )) //15 to 42
inverseFizzBuzz(List("buzz","fizz","buzz")) //no solution 

