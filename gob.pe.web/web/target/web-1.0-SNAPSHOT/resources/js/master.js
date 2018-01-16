Vue.options.delimiters = ['{', '}'];
var Global = Vue.extend({
    data:function(){
        return {
            usuario:{
                id:0,
                nombre:'Hola amigos como estan'
            }
        }    
    }
});
