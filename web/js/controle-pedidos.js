let tb = document.getElementById('tbody')

function getPedidos(){

    const api = axios.create({
        baseURL:'http://localhost:8080/ControleDeLanche',
        headers: {'X-Custom-Header': 'foobar'}
    })
    
      
        api.post('/relatorio')
            .then(function (x){
                let tb= document.getElementById('tbody');  

             x.data.forEach(element => {
                addRow(
                    element['cliente'],
                    element['pedido'],
                    element['valor'],
                    element['dtSaida'],
                    element['dtEntrega']
                )
                
        }
    
    }
}

function addRow(cliente, pedido, valor, dtSaida, dtEntrega) {

    if (dtSaida == '' && dtEntrega == '') {
        dtSaida = 'Pendente'
        dtEntrega = 'Pendente'
    }

    tb.innerHTML +=
    "<tr>" +
    "<td>"+cliente+"</td>" +
    "<td>"+pedido+"</td>" +
    "<td>"+valor+"</td>" +
    "<td>"+endereco+"</td>" +
    "<td>"+dtSaida+"</td>" +
    "<td>"+dtEntrega+"</td>" +
    "<td>" +
    "<a href=''><i class='fas fa-shipping-fast'></i></a>" +
    "<a href=''><i class='far fa-thumbs-up'></i></a> " +
    "</td>"+
    "</tr>"
}

function confirmaSaida() {
    //Inserir no BD
}

function confirmaEntrega(){
   //inserir no BD
}