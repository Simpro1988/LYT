/** layui-v2.6.6 MIT License By https://www.layui.com */
!function(win){var doc=document,config={modules:{},status:{},timeout:10,event:{}},Layui=function(){this.v="2.6.6"},GLOBAL=window.LAYUI_GLOBAL||{},getPath=function(){var jsPath=doc.currentScript?doc.currentScript.src:function(){var js=doc.scripts,last=js.length-1,src;for(var i=last;i>0;i--){if(js[i].readyState==="interactive"){src=js[i].src;break}}return src||js[last].src}();return config.dir=GLOBAL.dir||jsPath.substring(0,jsPath.lastIndexOf("/")+1)}(),error=function(msg,type){type=type||"log";win.console&&console[type]&&console[type]("layui error hint: "+msg)},isOpera=typeof opera!=="undefined"&&opera.toString()==="[object Opera]",modules=config.builtin={lay:"lay",layer:"layer",laydate:"laydate",laypage:"laypage",laytpl:"laytpl",layedit:"layedit",form:"form",upload:"upload",dropdown:"dropdown",transfer:"transfer",tree:"tree",table:"table",element:"element",rate:"rate",colorpicker:"colorpicker",slider:"slider",carousel:"carousel",flow:"flow",util:"util",code:"code",jquery:"jquery",all:"all","layui.all":"layui.all"};Layui.prototype.cache=config;Layui.prototype.define=function(deps,factory){var that=this,type=typeof deps==="function",callback=function(){var setApp=function(app,exports){layui[app]=exports;config.status[app]=true};typeof factory==="function"&&factory(function(app,exports){setApp(app,exports);config.callback[app]=function(){factory(setApp)}});return this};type&&(factory=deps,deps=[]);that.use(deps,callback,null,"define");return that};Layui.prototype.use=function(apps,callback,exports,from){var that=this,dir=config.dir=config.dir?config.dir:getPath,head=doc.getElementsByTagName("head")[0];apps=function(){if(typeof apps==="string"){return[apps]}else{if(typeof apps==="function"){callback=apps;return["all"]}}return apps}();if(window.jQuery&&jQuery.fn.on){that.each(apps,function(index,item){if(item==="jquery"){apps.splice(index,1)}});layui.jquery=layui.$=jQuery}var item=apps[0],timeout=0;exports=exports||[];config.host=config.host||(dir.match(/\/\/([\s\S]+?)\//)||["//"+location.host+"/"])[0];function onScriptLoad(e,url){var readyRegExp=navigator.platform==="PLaySTATION 3"?/^complete$/:/^(complete|loaded)$/;if(e.type==="load"||(readyRegExp.test((e.currentTarget||e.srcElement).readyState))){config.modules[item]=url;head.removeChild(node);(function poll(){if(++timeout>config.timeout*1000/4){return error(item+" is not a valid module","error")}config.status[item]?onCallback():setTimeout(poll,4)}())}}function onCallback(){exports.push(layui[item]);apps.length>1?that.use(apps.slice(1),callback,exports,from):(typeof callback==="function"&&function(){if(layui.jquery&&typeof layui.jquery==="function"&&from!=="define"){return layui.jquery(function(){callback.apply(layui,exports)})}callback.apply(layui,exports)}())}if(apps.length===0||(layui["layui.all"]&&modules[item])){return onCallback(),that}var url=(modules[item]?(dir+"modules/"):(/^\{\/\}/.test(that.modules[item])?"":(config.base||"")))+(that.modules[item]||item)+".js";url=url.replace(/^\{\/\}/,"");if(!config.modules[item]&&layui[item]){config.modules[item]=url}if(!config.modules[item]){var node=doc.createElement("script");node.async=true;node.charset="utf-8";node.src=url+function(){var version=config.version===true?(config.v||(new Date()).getTime()):(config.version||"");return version?("?v="+version):""}();head.appendChild(node);if(node.attachEvent&&!(node.attachEvent.toString&&node.attachEvent.toString().indexOf("[native code")<0)&&!isOpera){node.attachEvent("onreadystatechange",function(e){onScriptLoad(e,url)})}else{node.addEventListener("load",function(e){onScriptLoad(e,url)},false)}config.modules[item]=url}else{(function poll(){if(++timeout>config.timeout*1000/4){return error(item+" is not a valid module","error")}(typeof config.modules[item]==="string"&&config.status[item])?onCallback():setTimeout(poll,4)}())}return that};Layui.prototype.getStyle=function(node,name){var style=node.currentStyle?node.currentStyle:win.getComputedStyle(node,null);return style[style.getPropertyValue?"getPropertyValue":"getAttribute"](name)};Layui.prototype.link=function(href,fn,cssname){var that=this,head=doc.getElementsByTagName("head")[0],link=doc.createElement("link");if(typeof fn==="string"){cssname=fn}var app=(cssname||href).replace(/\.|\//g,""),id=link.id="layuicss-"+app,STAUTS_NAME="creating",timeout=0;link.rel="stylesheet";link.href=href+(config.debug?"?v="+new Date().getTime():"");link.media="all";if(!doc.getElementById(id)){head.appendChild(link)}if(typeof fn!=="function"){return that}(function poll(status){var delay=100,getLinkElem=doc.getElementById(id);if(++timeout>config.timeout*1000/delay){return error(href+" timeout")}if(parseInt(that.getStyle(getLinkElem,"width"))===1989){if(status===STAUTS_NAME){getLinkElem.removeAttribute("lay-status")}getLinkElem.getAttribute("lay-status")===STAUTS_NAME?setTimeout(poll,delay):fn()}else{getLinkElem.setAttribute("lay-status",STAUTS_NAME);setTimeout(function(){poll(STAUTS_NAME)},delay)}}());return that};Layui.prototype.addcss=function(firename,fn,cssname){return layui.link(config.dir+"css/"+firename,fn,cssname)};config.callback={};Layui.prototype.factory=function(modName){if(layui[modName]){return typeof config.callback[modName]==="function"?config.callback[modName]:null}};Layui.prototype.img=function(url,callback,error){var img=new Image();img.src=url;if(img.complete){return callback(img)}img.onload=function(){img.onload=null;typeof callback==="function"&&callback(img)};img.onerror=function(e){img.onerror=null;typeof error==="function"&&error(e)}};Layui.prototype.config=function(options){options=options||{};for(var key in options){config[key]=options[key]}return this};Layui.prototype.modules=function(){var clone={};for(var o in modules){clone[o]=modules[o]}return clone}();Layui.prototype.extend=function(options){var that=this;options=options||{};for(var o in options){if(that[o]||that.modules[o]){error(o+" Module already exists","error")}else{that.modules[o]=options[o]}}return that};Layui.prototype.router=function(hash){var that=this,hash=hash||location.hash,data={path:[],search:{},hash:(hash.match(/[^#](#.*$)/)||[])[1]||""};if(!/^#\//.test(hash)){return data}hash=hash.replace(/^#\//,"");data.href="/"+hash;hash=hash.replace(/([^#])(#.*$)/,"$1").split("/")||[];that.each(hash,function(index,item){/^\w+=/.test(item)?function(){item=item.split("=");data.search[item[0]]=item[1]}():data.path.push(item)});return data};Layui.prototype.url=function(href){var that=this,data={pathname:function(){var pathname=href?function(){var str=(href.match(/\.[^.]+?\/.+/)||[])[0]||"";return str.replace(/^[^\/]+/,"").replace(/\?.+/,"")}():location.pathname;return pathname.replace(/^\//,"").split("/")}(),search:function(){var obj={},search=(href?function(){var str=(href.match(/\?.+/)||[])[0]||"";return str.replace(/\#.+/,"")}():location.search).replace(/^\?+/,"").split("&");that.each(search,function(index,item){var _index=item.indexOf("="),key=function(){if(_index<0){return item.substr(0,item.length)}else{if(_index===0){return false}else{return item.substr(0,_index)}}}();if(key){obj[key]=_index>0?item.substr(_index+1):null}});return obj}(),hash:that.router(function(){return href?((href.match(/#.+/)||[])[0]||"/"):location.hash}())};return data};Layui.prototype.data=function(table,settings,storage){table=table||"layui";storage=storage||localStorage;if(!win.JSON||!win.JSON.parse){return}if(settings===null){return delete storage[table]}settings=typeof settings==="object"?settings:{key:settings};try{var data=JSON.parse(storage[table])}catch(e){var data={}}if("value" in settings){data[settings.key]=settings.value}if(settings.remove){delete data[settings.key]}storage[table]=JSON.stringify(data);return settings.key?data[settings.key]:data};Layui.prototype.sessionData=function(table,settings){return this.data(table,settings,sessionStorage)};Layui.prototype.device=function(key){var agent=navigator.userAgent.toLowerCase(),getVersion=function(label){var exp=new RegExp(label+"/([^\\s\\_\\-]+)");label=(agent.match(exp)||[])[1];return label||false},result={os:function(){if(/windows/.test(agent)){return"windows"}else{if(/linux/.test(agent)){return"linux"}else{if(/iphone|ipod|ipad|ios/.test(agent)){return"ios"}else{if(/mac/.test(agent)){return"mac"}}}}}(),ie:function(){return(!!win.ActiveXObject||"ActiveXObject" in win)?((agent.match(/msie\s(\d+)/)||[])[1]||"11"):false}(),weixin:getVersion("micromessenger")};if(key&&!result[key]){result[key]=getVersion(key)}result.android=/android/.test(agent);result.ios=result.os==="ios";result.mobile=(result.android||result.ios)?true:false;return result};Layui.prototype.hint=function(){return{error:error}};Layui.prototype.each=function(obj,fn){var key,that=this,callFn=function(key,obj){return fn.call(obj[key],key,obj[key])};if(typeof fn!=="function"){return that}obj=obj||[];if(obj.constructor===Object){for(key in obj){if(callFn(key,obj)){break}}}else{for(key=0;key<obj.length;key++){if(callFn(key,obj)){break}}}return that};Layui.prototype.sort=function(obj,key,desc){var clone=JSON.parse(JSON.stringify(obj||[]));if(!key){return clone}clone.sort(function(o1,o2){var isNum=/^-?\d+$/,v1=o1[key],v2=o2[key];if(isNum.test(v1)){v1=parseFloat(v1)}if(isNum.test(v2)){v2=parseFloat(v2)}if(v1&&!v2){return 1}else{if(!v1&&v2){return -1}}if(v1>v2){return 1}else{if(v1<v2){return -1}else{return 0}}});desc&&clone.reverse();return clone};Layui.prototype.stope=function(thisEvent){thisEvent=thisEvent||win.event;try{thisEvent.stopPropagation()}catch(e){thisEvent.cancelBubble=true}};Layui.prototype.onevent=function(modName,events,callback){if(typeof modName!=="string"||typeof callback!=="function"){return this}return Layui.event(modName,events,null,callback)};Layui.prototype.event=Layui.event=function(modName,events,params,fn){var that=this,result=null,filter=(events||"").match(/\((.*)\)$/)||[],eventName=(modName+"."+events).replace(filter[0],""),filterName=filter[1]||"",callback=function(_,item){var res=item&&item.call(that,params);res===false&&result===null&&(result=false)};if(params==="LAYUI-EVENT-REMOVE"){delete (that.cache.event[eventName]||{})[filterName];return that}if(fn){config.event[eventName]=config.event[eventName]||{};config.event[eventName][filterName]=[fn];return this}layui.each(config.event[eventName],function(key,item){if(filterName==="{*}"){layui.each(item,callback);return}key===""&&layui.each(item,callback);(filterName&&key===filterName)&&layui.each(item,callback)});return result};Layui.prototype.on=function(events,modName,callback){var that=this;return that.onevent.call(that,modName,events,callback)};Layui.prototype.off=function(events,modName){var that=this;return that.event.call(that,modName,events,"LAYUI-EVENT-REMOVE")};win.layui=new Layui()}(window);