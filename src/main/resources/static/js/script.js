function addElement(id){

  let data = $('#addElement').serialize();
  $.ajax({
        method: "POST",
        url: "/elements/" + id,
        data:  data
   });
  setTimeout('window.location.reload()',200);
}

function deleteElement(id){
    $.ajax({
       method: "DELETE",
       url: "/element/" + id,
    });
    setTimeout('window.location.reload()',200)
}


function getElement(id){
    $.ajax({
        method: "GET",
        url: "/element/" + id,
    });
    setTimeout('window.location.reload()',200)
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
    setTimeout('window.location.reload()',200)
}

function getElements(id){
    $.ajax({
        method: "GET",
        url: "/elements/" + id,
    });
    setTimeout('window.location.reload()',200)
}











