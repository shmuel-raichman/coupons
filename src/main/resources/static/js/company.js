// B"H

const compBaseUrl = "http://localhost:8080/rest/api/company"
const compID = 28
var rawCount = 1

function mylog(msg){
    console.log(msg);
}

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
    var action = `
    <div id="action${rawCount}}">
		<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" >update</button>

		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
				<div class="modal-content">
				<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Update coupon:</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
						</button>
				</div>
				<div class="modal-body" id="modelbody${rawCount}" rawcountdiv="${rawCount}">
                        <form id="updateCoupon${rawCount}" rawcountform="${rawCount}" onsubmit="submitMyForm(this)">
							<div class="form-group" rawcountformdiv="${rawCount}" id="rawcountformfirstdiv${rawCount}">
								<!-- <label for="recipient-name" class="col-form-label">Update coupon:</label> -->
								<br>
									<div class="input-group mb-3">
										<div class="input-group-prepend">
											<input id="updatePrice" type="checkbox" aria-label="Checkbox for following text input">  Update price.
											<span class="input-group-text">$</span>
											<span class="input-group-text">0.00</span>
											<input type="number" class="form-control" aria-label="Amount (to the nearest dollar)">
										</div>
									</div>
							</div>
								<div class="input-group mb-3" id="rawcountformsecendtdiv${rawCount}">
									<div class="input-group-prepend">
										<div class="input-group-text">
											<input type="checkbox" aria-label="Checkbox for following text input">  Update End date.
											<input type="date" id="date">
										</div>
									</div>
                            </div>
                            <div class="modal-footer">
                                    <button type="button" id="close${rawCount}" class="btn btn-secondary" data-dismiss="modal" data-target="#do_not_jump">Close</button>
                                    <button type="submit" class="btn btn-primary"  >Send message</button>
                            </div>
						</form>
				</div>
				
				</div>
		</div>
		</div>
    `;

    
    

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
            <td >${action}</td>
        </tr>`;
    $('#couponsTable').append(couponRaw);
}

function getCompanyCoupons(url){

    console.log("Get all Coupons");

    $.ajax({
        type: "GET",
        url: url,
        success: function(data){
            console.log(data);
            $('#couponsTable tbody').empty();
            rawCount = 1;
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
        var category = $(this).val()

        var url = compBaseUrl + "/getCouponsForCompanyByType?companyID=" + compID + "&category=" + category;

        switch(category) {
            case "BABY":
                // getCompanyCoupnsByType(url);
                getCompanyCoupons(url);
                break;
            case "SPORTS":
                // getCompanyCoupnsByType(url);
                getCompanyCoupons(url);
                break;
            case "HEALTH":
                // getCompanyCoupnsByType(url);
                getCompanyCoupons(url);
                break;
            case "FOOD":
                // getCompanyCoupnsByType(url);
                getCompanyCoupons(url);
                break;
            default:
                getCompanyCoupons(compBaseUrl + "/getAllCouponsForCompany/" + compID);
              break;
          }
      });
}

function submitMyForm(t){
    console.log("Form");

    var id = t.id;
    var count = t.rawcountform;
    var formdiv = t.rawcountformdiv;
    var myform =  $("#" + id);
    var count = myform[0].attributes[1].value
    mylog(myform);

    var updatePrice = myform[0][0].checked;
    var newprice = myform[0][1].value;
    var updatedate = myform[0][2].checked;
    var newdate = myform[0][3].value;

    $("#rawcountformfirstdiv" + count).empty();
    $("#rawcountformfirstdiv" + count).append("<div class=text>" + updatePrice + " - "+  newprice + "</div>");

    $("#rawcountformsecendtdiv" + count).empty();
    $("#rawcountformsecendtdiv" + count).append("<div class=text>" + updatedate + " - " + newdate + "</div>");

    var action = `
    
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" >update</button>

            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                    <div class="modal-content">
                    <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Update coupon:</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                            </button>
                    </div>
                    <div class="modal-body" id="modelbody${rawCount}" rawcountdiv="${rawCount}">
                            <form id="updateCoupon${rawCount}" rawcountform="${rawCount}" onsubmit="submitMyForm(this)">
                                <div class="form-group" rawcountformdiv="${rawCount}" id="rawcountformfirstdiv${rawCount}">
                                    <!-- <label for="recipient-name" class="col-form-label">Update coupon:</label> -->
                                    <br>
                                        <div class="input-group mb-3">
                                            <div class="input-group-prepend">
                                                <input id="updatePrice" type="checkbox" aria-label="Checkbox for following text input">  Update price.
                                                <span class="input-group-text">$</span>
                                                <span class="input-group-text">0.00</span>
                                                <input type="number" class="form-control" aria-label="Amount (to the nearest dollar)">
                                            </div>
                                        </div>
                                </div>
                                    <div class="input-group mb-3" id="rawcountformsecendtdiv${rawCount}">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <input type="checkbox" aria-label="Checkbox for following text input">  Update End date.
                                                <input type="date" id="date">
                                            </div>
                                        </div>
                                </div>
                                <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal" data-target="#do_not_jump">Close</button>
                                        <button type="submit" class="btn btn-primary"  >Send message</button>
                                </div>
                            </form>
                    </div>
                    
                    </div>
            </div>
            </div>
        `;

    
    $("#close" + count).click(function(){
        
        $("#action"+ count).append(action);
        
    })

    window.location.href = "#do_not_jump"
}

$( document ).ready(function() {
    getCompanyCoupons(compBaseUrl + "/getAllCouponsForCompany/" + compID);
    // getAllCompanyCoupns(compBaseUrl + "/getAllCouponsForCompany/" + compID);
    console.log( "ready!" )
    selectCouponType();


    $( "form" ).submit(function( event ) {
        console.log("Form")
        // console.log( $( this ).serializeArray() );
        // event.preventDefault();
      });
});




