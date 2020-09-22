Java.perform(function(){
	Java.enumerateLoadedClasses({
		"onMatch":function(className){
			if(str.startWith('sg.vantagepoint')){
				console.log(str)
			}
		},
		
		"onComplete":function(){}
	})
})