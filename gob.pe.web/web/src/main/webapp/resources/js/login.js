var login = new Global({
   el:'#appLogin',        
   data:function(){
        return{
            valid: false,
            basico: {
                error: false,
                mensajeError: ''
            },
            usuarioRules: [
                (v) => !!v || 'El usuario es requerido.',
                (v) => v && v.length <= 10 || 'El usuario debe tener menos de 10 caracteres.'
            ],
            claveRules: [
                (v) => !!v || 'La clave es requerida.',
                (v) => v && v.length <= 10 || 'La clave debe tener menos de 10 caracteres.'
            ]
        }
   },
    computed: {
        isComplete() {
            return this.usuario.usuario && this.usuario.clave;
        }
    },
   methods:{
       accederSistema: function(){
           let self = this; 
           if (self.$refs.form.validate()){
               axios({
                    url:this.urlBase + 'ajaxIngresarSistema',
                    method:'post',
                    data:this.usuario
                })
                .then(function(response){                    
                    if (response.data.success) {
                        location.href=self.urlBase + 'principal/';
                    }else{                        
                        if (response.data.errorNegocio) {
                            self.basico.error = true;
                            self.basico.mensajeError = response.data.message;
                            
                        }else{
                            console.log(response.data.message);
                        }                       
                    }
                })
                .catch(function(error){                    
                    console.log(error);
                });
           }
       }
      
   }
});
