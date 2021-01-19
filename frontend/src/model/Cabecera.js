class Cabecera{

    static instancia;
    cabecera;

    static instanciar(){
        if(!this.instancia)
            this.instancia = new Cabecera();
        return this.instancia;
    }

    setCabecera(cabecera){
        this.cabecera = cabecera;
    }

    getCabecera(){
        return this.cabecera;
    }

}
export default Cabecera