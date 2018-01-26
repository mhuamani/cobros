Vue.options.delimiters = ['[[', ']]'];
var Global = Vue.extend({
    data:function(){
        return {
            usuario:{
                id:0,
                nombre:'Hola amigos como estan'
            },
            loading:false,
            urlBase:'http://localhost:8080/cobros/'
        }    
    }
});
