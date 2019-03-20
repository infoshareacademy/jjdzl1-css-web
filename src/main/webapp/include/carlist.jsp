<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row my-4">
  <div class="col-lg-12">
      <h2>Our cars</h2>

      ${error}
      ${emptyData}
          <table class="table table-striped">
              <tr>
                  <th style="text-align: center; vertical-align: middle;">Photo</th>
                  <th style="text-align: center; vertical-align: middle;">Make</th>
                  <th style="text-align: center; vertical-align: middle;">Model</th>
                  <th style="text-align: center; vertical-align: middle;">Year</th>
                  <th style="text-align: center; vertical-align: middle;">Fuel source</th>
                  <th style="text-align: center; vertical-align: middle;">Engine power</th>
                  <th style="text-align: center; vertical-align: middle;">Transmission</th>
              </tr>

              <c:forEach var="car" items="${carExampleList}">
                  <tr>
                      <td><c:choose>
                          <c:when test="${car.id==1}"><img src="img/1.jpeg" height="150" width="225" ></c:when>
                          <c:when test="${car.id==2}"><img src="img/2.jpeg" height="150" width="225" ></c:when>
                          <c:when test="${car.id==3}"><img src="img/3.jpeg" height="150" width="225" ></c:when>
                          <c:when test="${car.id==4}"><img src="img/4.jpeg" height="150" width="225" ></c:when>
                          <c:when test="${car.id==5}"><img src="img/5.jpeg" height="150" width="225" ></c:when>
                          <c:when test="${car.id==6}"><img src="img/6.jpeg" height="150" width="225" ></c:when>
                          <c:when test="${car.id==7}"><img src="img/7.jpeg" height="150" width="225" ></c:when>
                          <c:when test="${car.id==8}"><img src="img/8.jpeg" height="150" width="225" ></c:when>
                      </c:choose>
                      </td>
                      <td style="text-align: center; vertical-align: middle;">${car.make}</td>
                      <td style="text-align: center; vertical-align: middle;">${car.model}</td>
                      <td style="text-align: center; vertical-align: middle;">${car.year}</td>
                      <td style="text-align: center; vertical-align: middle;">${car.fuelSource}</td>
                      <td style="text-align: center; vertical-align: middle;">${car.enginePower}</td>
                      <td style="text-align: center; vertical-align: middle;">${car.transmission}</td>
                  </tr>
              </c:forEach>
          </table>
      <br>
      <div class="alert alert-primary" role="alert">
          Do you want to reserve one of those cars? <a href="login" class="alert-link">Log in here</a>
      </div>

  </div>
</div>