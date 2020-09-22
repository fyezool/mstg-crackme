/*

Java.perform(function(){
	var theClass = Java.use("sg.vantagepoint.a.c");

	theClass.a.implementation = function(v){
		console.log("In function a");
		return false;
	}

	theClass.b.implementation = function(v){
		console.log("In function b");
		return false;
	}

	theClass.c.implementation = function(v){
		console.log("In function c");
			return false
	}

	console.log("Exploit Complete")
})

*/

Java.perform(function() {
  Java.use("sg.vantagepoint.uncrackable1.MainActivity").a.implementation = function(s) {
    console.log("Tamper detection suppressed, message was: " + s);
  }
});