$(document).ready(
    function () {
        var url = "rest/magasin";
        var posting = $.ajax(url, {
            url : url,
            type: 'POST',
            /* callback de la Request 202 */
            success : function (result){
                $('#tablePanier').html(result);
            }
        });

        posting.fail(function(data) {
            console.info("failed : " + data);
        });
    }
);

function RemoveToPanier(id){
    var url = "rest/magasin?id="+id;
    var posting = $.ajax(url, {
        url : url,
        type: 'DELETE',
        /* callback de la Request 202 */
        success : function (){
            alert("Suppression effectuer id : "+id);
            window.location.reload();
        }
    });

    posting.fail(function(data) {
        console.info(data);
    });
}