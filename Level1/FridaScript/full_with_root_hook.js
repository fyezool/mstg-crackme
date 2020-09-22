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

  var rootcheck1 = Java.use("sg.vantagepoint.a.c");
  rootcheck1.a.overload().implementation = function() {
    send("sg.vantagepoint.a.c.a()Z   Root check 1 HIT!  su.exists()");
    return false;
  };

  var rootcheck2 = Java.use("sg.vantagepoint.a.c");
  rootcheck2.b.overload().implementation = function() {
    send("sg.vantagepoint.a.c.b()Z  Root check 2 HIT!  test-keys");
    return false;
  };

  var rootcheck3 = Java.use("sg.vantagepoint.a.c");
  rootcheck3.c.overload().implementation = function() {
    send("sg.vantagepoint.a.c.c()Z  Root check 3 HIT!  Root packages");
    return false;
  };

  var debugcheck = Java.use("sg.vantagepoint.a.b");
  debugcheck.a.overload("android.content.Context").implementation = function(var_0) {
    send("sg.vantagepoint.a.b.a(Landroid/content/Context;)Z  Debug check HIT! ");
    return false;
  };

  send("Hooks installed.");
});