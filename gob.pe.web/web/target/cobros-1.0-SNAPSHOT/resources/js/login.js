var login = new Global({
   el:'#appLogin',   
   data(){
        return {
            valid: false,
            usuarioRules: [
                (v) => !!v || 'El usuario es requerido.',
                (v) => v && v.length <= 10 || 'El usuario debe tener menos de 10 caracteres.'
            ],
            claveRules: [
                (v) => !!v || 'La clave es requerida.',
                (v) => v && v.length <= 10 || 'La clave debe tener menos de 10 caracteres.'
            ]
        };
   },
   methods:{
       accederSistema: function(){
           this.loading = true;     
           console.log(this.usuario);
           axios({
                    url:this.urlBase + 'ingresarSistema',
                    method:'post',
                    data:this.usuario
                })
                .then(function(response){
                    console.log(response.data);
                })
                .catch(function(error){
                    console.log(error.data);
                });
       }
   }
});
