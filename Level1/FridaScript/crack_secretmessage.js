function bufferToString(buf) {
  var buffer = Java.array('byte', buf);
  var result = "";
  for(var i = 0; i < buffer.length; ++i){
    result += (String.fromCharCode(buffer[i] & 0xff));
  }

  return result;
}

Java.use("sg.vantagepoint.a.a").a.implementation = function(ba1, ba2){
  const retval = this.a(ba1, ba2);
  console.log("Secret Code is: " + bufferToString(retval));
  return retval;
}