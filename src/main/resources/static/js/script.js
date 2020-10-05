function addElement(id){
  let data = $('#addElement' + id).serialize();
  $.ajax({
        method: "POST",
        url: "/element/" + id,
        data:  data
   });
  setTimeout('window.location.reload()',200);
}

function deleteElement(id){
    $.ajax({
       method: "DELETE",
       url: "/element/" + id,
    });
    setTimeout('window.location.reload()',200);
}

function updateElement() {
    let data = $('#updElement').serialize();
    $.ajax({
        method: "PUT",
        url: "/element/update",
        data: data
    });
    setTimeout('window.location.reload()',200);
}

function activeUpdate(id) {
    $.ajax({
        method: "GET",
        url: "/element/" + id,
        success: function (response){
            let o = document.getElementById("updElement");
            o[0].value = response.id;
            o[1].value = response.name;
            o[2].value = response.code;
            o[3].value = response.group.id;
        }
    });
}

function addElements(){

    let data = $('#addBox').serialize();
    $.ajax({
        method: "POST",
        url: "/elements",
        data:  data
    });
    setTimeout('window.location.reload()',200);
}

function deleteElements(id){
    $.ajax({
        method: "DELETE",
        url: "/elements/" + id,
    });
    setTimeout('window.location.reload()',200);
}

function getElement(id){
    $.ajax({
        method: "GET",
        url: "/element/" + id,
        success: function (response){
            return response;
        }
    });
    setTimeout('window.location.reload()',200);
}











