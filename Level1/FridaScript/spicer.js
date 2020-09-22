//Helper function to decode byte[] to String
function arrToStr(byteArr) {
tmp = "";
for (k = 0; k < byteArr.length; k++) {
tmp += String.fromCharCode(byteArr[k]);
}
return tmp;
}

// Java.perform wraps all of our Frida code.
Java.perform(function() {
//
classAC = Java.use("sg.vantagepoint.a.c");

classAC.a.implementation = function(x) {
console.log("In function A");
return false;
};
classAC.b.implementation = function(x) {
console.log("In function B");
return false;
};
classAC.c.implementation = function(x) {
console.log("In function C");
return false;
};

console.log("Root Bypass Complete");

// ---- vv ------- Part 2 ----- vv ----- //

console.log("Finding Password....");

classAA = Java.use("sg.vantagepoint.a.a");
// Method a() in a.a
classAA.a.implementation = function(x1, x2) {
console.log("In function a.a.a()");
// Call this function and store its return value
//x1 and x2 are the variables the _app_ is calling with.
rawFunctionCall = this.a(x1, x2);
// Convert Byte[] to String
output = arrToStr(rawFunctionCall);
// Log the password.
console.log("=====> " + output);
return rawFunctionCall;
};
});