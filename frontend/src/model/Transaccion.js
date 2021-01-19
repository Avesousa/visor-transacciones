class Transaccion{

    static instancia;

    transacciones;
    bool;

    static instanciar(){
        if(!this.instancia)
            this.instancia = new Transaccion();
        return this.instancia;
    }

    //Ordenado según creación de variable
    setTrans(transacciones,bool){
        this.transacciones = transacciones;
        this.bool = bool;
    }

    getTrans(){
        return this.transacciones;
    }

    getBool(){
        return this.bool;
    }

}
export default Transaccion;