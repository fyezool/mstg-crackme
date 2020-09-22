Java.perform(function () {
  send("Starting hooks OWASP uncrackable1...");

  function getString(data){
    var ret = "";
    for (var i=0; i < data.length; i++){
        ret += "#" + data[i].toString();
      }
    return ret
  } 

  var aes_decrypt = Java.use("sg.vantagepoint.a.a");
  aes_decrypt.a.overload("[B","[B").implementation = function(var_0,var_1) {
    send("sg.vantagepoint.a.a.a([B[B)[B   doFinal(enc)  // AES/ECB/PKCS7Padding");
    send("Key       : " + getString(var_0));
    send("Encrypted : " + getString(var_1));
    var ret = this.a.overload("[B","[B").call(this,var_0,var_1);
    send("Decrypted : " + getString(ret));

    var flag = "";
    for (var i=0; i < ret.length; i++){
      flag += String.fromCharCode(ret[i]);
    }
    send("Decrypted flag: " + flag);
    return ret; //[B
  };

  var sysexit = Java.use("java.lang.System");
  sysexit.exit.overload("int").implementation = function(var_0) {
    send("java.lang.System.exit(I)V  // We avoid exiting the application  :)");
  };

  send("Hooks installed.");
});

