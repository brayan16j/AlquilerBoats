
$(document).ready(function (){
    getCategoryList();
    getBoat();
})

function getFrontBoatData(){
    let k={
        id:$("#idBoat").val(),
        name:$("#nameBoat").val(),
        brand:$("#brandBoat").val(),
        year:$("#yearBoat").val(),
        description:$("#descriptionBoat").val(),
        category:{
            id:$("#categorySelect").val()
        }
    }
    return k;
}

function getCategoryList(){
    $.ajax({
        url : 'api/Category/all',
        type : 'GET',
        dataType : 'json',

        success : function(p){
            console.log(p);
            $("#categorySelect").empty();
            for (let i=0;i<p.length;i++){
                let s=`
                 <option value="${p[i].id}">${p[i].name}</option>
                `;
                $("#categorySelect").append(s);
            }
        },
        error : function(xhr, status){
            alert('ha sucedido un problema');
        },
        complete : function (xhr,status){
            // alert("Peticion realizada");
        }
    });
}

function saveBoat(){


    alert("Hola Mundo");
    let data =getFrontBoatData();
    data.id=null;
    let dataToSend=JSON.stringify(data);

    $.ajax({
        url : 'api/Boat/save',
        type : 'POST',
        dataType : 'json',
        contentType: 'application/json',
        data:dataToSend,
        success : function(p){
            console.log(p);
        },
        error : function(xhr, status){
            alert('ha sucedido un problema');
        },
        complete : function (xhr,status){
            // alert("Peticion realizada");
        }
    });
}

function getBoat (){
// FUNCION GET
    $.ajax({
        url : 'api/Boat/all',
        type : 'GET',
        dataType : 'json',

        success : function(p){
            console.log(p);
            $("#results").empty();
            let b="";
            for (let i=0; i<p.length; i++){
                l+= `<div className="col">
                        <div className="card">
                                <div className="card-body">
                                    <h5 className="card-title">${p[i].name}</h5>
                                    <p className="card-text">${p[i].description}</p>
                                    <p className="card-text">Year: ${p[i].year}</p>
                                     <p className="card-text">Brand: ${p[i].brand}</p>
                                </div>
                        </div>
                    </div>
                    `;
            }
            $("#results").append(b);

        },
        error : function(xhr, status){
            alert('ha sucedido un problema');
        },
        complete : function (xhr,status){
            // alert("Peticion realizada");
        }
    });
}