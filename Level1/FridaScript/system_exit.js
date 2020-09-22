setImmediate(function() { //prevent timeout
  console.log("[*] Starting script");

  Java.perform(function(){
    console.log("[*] Hooking calls to System.exit");
    exitClass = Java.use("java.lang.System");
    exitClass.exit.implementation = function(){
      console.log("[*] System.exit called");
    }
  });

})