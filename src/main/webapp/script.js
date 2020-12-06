$(document).ready(
    function () {
        var url = "rest/magasin";
        var posting = $.ajax(url, {
            url : url,
            type: 'GET',
            /* callback de la Request 202 */
            success : function (result){
                $('#tableMag').html(result);
            }
        });

        posting.fail(function(data) {
            console.info(data);
        });
    }
);

function AddToPanier(id){
    var url = "rest/magasin?id="+id;
    var posting = $.ajax(url, {
        url : url,
        type: 'PUT',
        /* callback de la Request 202 */
        success : function (){
            alert("ajout effectuer");
        }
    });

    posting.fail(function(data) {
        console.info(data);
    });
}