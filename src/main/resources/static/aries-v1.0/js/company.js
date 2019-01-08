// B"H

const compBaseUrl = "http://localhost:8080/rest/api/company"
const compID = 28
var rawCount = 2


function papulateTable(data){
    
    console.log( "ppulate table." );

    var couponID = data.id
    var title = data.title
    var startDate = data.startDate
    var endDate = data.endDate
    var amount = data.amount
    var price = data.price
    var message = data.message
    var imageLink = data.imageLink
    var couponCategory = data.couponCategory

    let couponRaw = `<tr>
            <th scope="row">${rawCount++}</th>
            <td >${couponID}</td>
            <td >${title}</td>
            <td >${startDate}</td>
            <td >${endDate}</td>
            <td >${amount}</td>
            <td >${message}</td>
            <td >${price}</td>
            <td >${imageLink}</td>
            <td >${couponCategory}</td>
        </tr>`;
    $('#couponsTable').append(couponRaw);
}

function MyCompanyDetiles(data){
    
    console.log( "ppulate table." );

    var couponID = data.id
    var title = data.title
    var startDate = data.startDate
    var endDate = data.endDate
    var amount = data.amount
    var price = data.price
    var message = data.message
    var imageLink = data.imageLink
    var couponCategory = data.couponCategory

    let couponRaw = `<tr>
            <th scope="row">${rawCount++}</th>
            <td >${couponID}</td>
            <td >${title}</td>
            <td >${startDate}</td>
            <td >${endDate}</td>
            <td >${amount}</td>
            <td >${message}</td>
            <td >${price}</td>
            <td >${imageLink}</td>
            <td >${couponCategory}</td>
        </tr>`;
    $('#couponsTable').append(couponRaw);
  
}

function getAllCompanyCoupns(){
    console.log("Get all Coupons");

    $.ajax({
        type: "GET",
        url: compBaseUrl + "/getAllCouponsForCompany/" + compID,
        success: function(data){
            console.log(data);
            $('#couponsTable tbody').empty();
            data.forEach(function(element) {
                papulateTable(element);
              })
        },
        failure: function(errMsg) {
            alert(errMsg);
        },
        error: function(  errorThrown ){
                    console.log( errorThrown );
                }
    });
}

function getCompanyCoupnsByType(category){
    console.log("Get all Coupons");

    $.ajax({
        type: "GET",
        url: compBaseUrl + "/getCouponsForCompanyByType?companyID=" + compID + "&category=" + category,
        success: function(data){
            console.log(data);
            $('#couponsTable tbody').empty();

            data.forEach(function(element) {
                papulateTable(element);
              })
        },
        failure: function(errMsg) {
            alert(errMsg);
        },
        error: function(  errorThrown ){
                    console.log( errorThrown );
                }
    });
}

function selectCouponType(){
    $('#category').change(function(){ 
        //do stuff here, eg. 
        var val = $(this).val()
        
        switch(val) {
            case "BABY":
                getCompanyCoupnsByType(val);
                break;
            case "SPORTS":
                getCompanyCoupnsByType(val);
                break;
            case "HEALTH":
                getCompanyCoupnsByType(val);
                break;
            case "FOOD":
                getCompanyCoupnsByType(val);
                break;
            default:
              getAllCompanyCoupns();
              break;
          }
      });
}

$( document ).ready(function() {
    getAllCompanyCoupns();
    console.log( "ready!" )
    selectCouponType();

});


