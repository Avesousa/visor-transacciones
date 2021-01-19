'use strict'

import CommonsService from '../commons/js/CommonsService';

const axios = require('axios');

class Connection extends CommonsService {

    static instancia;

    static instanciar(){
        if(!this._instancia)
            this._instancia = new Connection();
        return this._instancia;
    }

    conectar(method,host,data){
        if(method == "POST"){
            return new Promise((resolve,reject) => {
                axios({
                    method: method,
                    url: host,
                    data: data,
                    headers: this.authHeader
                })
                .then(res =>{
                    resolve(this.devolucion(res,true));
                })
                .catch(error =>{
                    console.log(error);
                    console.log("("+error.response.data.error+"): " + error.response.data.mensaje);
                    reject(this.devolucion(error,false));
                });
            });
        }else{
            return new Promise((resolve,reject) => {
                axios({
                    method: method,
                    url: host,
                    params: data,
                    headers: this.authHeader
                })
                .then(res =>{
                    resolve(this.devolucion(res,true));
                    console.log(res);
                })
                .catch(error =>{
                    console.log(error);
                    console.log("("+error.response.data.error+"): " + error.response.data.mensaje);
                    reject(this.devolucion(error,false));
                });
            });
        }
    }
    devolucion(valor,bool){
        if(valor){
            if(bool){
                return {
                    "tipo": bool,
                    "resultado": valor.data,
                };
            } else{
                if(valor.response){
                    return {
                        "tipo": bool,
                        "error": valor.response.data.error,
                        "mensaje": valor.response.data.mensaje,
                        "flag": valor.response.data.error == "401"
                    }
                }else{
                    return {
                        "tipo": bool,
                        "error": "Error en el servidor",
                        "mensaje": "Ocurrió un error al intentar conectarse al webservice",
                        "flag": false
                    }
                }
            }
        }else{
            return{
                "tipo": false,
                "error": 512,
                "mensaje": "No se pudo comunicar con el servidor"
            }
        }
    }

}

export default Connection