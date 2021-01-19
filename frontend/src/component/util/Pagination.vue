<template>
    <div class="row pagination">
        <div class="col-12 col-xl-6">
            <select name="selectPerPage" id="selectPerPage" v-model="perPage">
                <option value="5">5</option>
                <option value="15">15</option>
                <option value="25">25</option>
            </select>
            <p class="displayPagination">Página {{page}} de {{countPage}}</p>
        </div>
        <div class="col-12 col-xl-6">
            <div class="row">
                <div class="col-12">
                    <div class="controlPagination">
                        <ul>
                            <li @click="prevPage()">
                                <a><</a>
                            </li>
                            <li @click="setPage((page-countButton))" v-if="page > countButton">
                                <a>...</a>
                            </li>
                            <li @click="setPage(((page-countButton) > 0 ? (page-countButton) : 0) + (index+1))" 
                                v-for="(valor,index) in (countPage > (countButton+1)) ? countButton : countPage" 
                                :class="(page == ((page-countButton) > 0 ? (page-countButton) : 0) + (index+1)) ? 'selected' : ''">
                                <a>{{((page-countButton) > 0 ? (page-countButton) : 0) + (index+1)}}</a>
                            </li>
                            <li @click="setPage(countPage)" v-if="countPage > 10 && countPage > page">
                                <a>...</a>
                            </li>
                            <li @click="nextPage()">
                                <a>></a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
</template>
<script>
export default {
    
    name: "pagination",
    data(){
        return{
            page: 1,
            perPage: "5",
            countPage: 0,
            countButton: 9
        }
    },
    props:{
        rows: {
            type: Number,
            default: 1
        }
    },
    methods:{
        prevPage () { 
            this.page > 1 ? this.page-- : null;
        },
        nextPage () { 
            this.countPage > this.page ? this.page ++ : null;
        },
        changePage(){
            console.log("Pagination-page: " + this.page + " -por pagina: " + this.perPage);
            this.countPage = this.redondear(this.rows/parseInt(this.perPage));
            this.page = this.countPage > this.page ? this.page : this.countPage;
            let start_response = (this.page - 1) * parseInt(this.perPage);
            let end_response = (start_response + parseInt(this.perPage));
            console.log("Start: " + start_response + " end: " + end_response);
            return {
                start: start_response,
                end: end_response
            }
        },
        setPage(pag){
            this.page = pag;
        },
        redondear(num){
            let valor = num.toString().split(".");
            let entero = parseInt(valor[0]);
            let decimal = parseInt(valor[1]);
            return decimal > 0 ? ( entero + 1 ) : entero;
        },
        limpiar(){
            this.rows = 0;
            this.page = 1;
            this.countPage = 0;
            this.perPage = "5";
        }
    }
}
</script>
<style>
    
    .pagination{
        margin-top: 5px;
    }

    .controlPagination ul{
        list-style: none;
        float: right;
    }

    .controlPagination ul li{
        float: left;
        border-top: 1px solid #ddd;
        border-bottom: 1px solid #ddd;
        border-left: 1px solid #ddd;
        padding: 6px 12px;
        cursor: pointer;
        line-height: 1.43;
        color: #757575;
    }

    .controlPagination ul li:first-child{
        border-top-left-radius: 3px;
        border-bottom-left-radius: 3px;
    }

    .controlPagination ul li:last-child{
        border-right: 1px solid #ddd;
        border-top-right-radius: 3px;
        border-bottom-right-radius: 3px;
    }

    .controlPagination ul li.selected{
        color: #fff;
        cursor: default;
        background-color: #ffae37;
        border-color: #ffae37;
    }

    .controlPagination a{
        cursor: pointer;
        margin-right: 2px;
    }

    .controlPagination a.flecha{
        font-weight: bold;
    }

    .displayPagination{
        display: inline-block;
    }
</style>