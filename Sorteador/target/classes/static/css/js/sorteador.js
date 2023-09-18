$(document).ready(function () { //$('html').html(data)
  $("#btnSorteador").click(function () {
    var quantity = $("#quantity").val();
    var begin = $("#begin").val();
    var end = $("#end").val();
    var ordemIncrease = $("#ordemIncrease").is(":checked");
    var repetition = $("#repetition").is(":checked");

    $.ajax({
      type: "POST", // Tipo da requisição
      url: "/", // Caminho para envio da requisição
      data: { quantity: quantity, begin: begin, end: end, ordemIncrease: ordemIncrease, repetition: repetition },
      success: function (data) {
        $("#errorMessage").text("");
        if (data.sucesso) {
          $("#resultado").text(data);
          window.location.href = "/resultado";
        } else {
          $("#errorMessage").append("Ops! Ocorreu um erro inesperado.");
        }
      },
      error: function () {
        $("#errorMessage").append("Ops! Ocorreu um erro inesperado.");
      },
    });
  });
});