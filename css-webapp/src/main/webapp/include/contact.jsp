<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section class="jumbotron">
    <div class="container">
        <h1 class="jumbotron-heading text-center"><img src="img/css-logo.png" width="35" height="35" class="d-inline-block mr-1" alt=""><span class="d-none d-md-block">CarSharingSystem</span><span class="d-sm-block d-md-none">CSS</span></h1>
        <h4>Contact us</h4>
        ${messageSent}
        <form class="needs-validation" action="contact" method="post" id="contact">
            <div class="form-group">
                <label for="inputemail">Your email</label>
                <input type="email" class="form-control" name="from" id="inputemail"
                <c:if test="${sessionScope.username != null}"> value="${currentUser.email}"</c:if>
                placeholder="you@example.com" required>
            </div>
            <div class="form-group">
                <label for="inputsubject">Subject</label>
                <input type="text" class="form-control" name="subject" id="inputsubject" placeholder="Subject" required>
            </div>
            <div class="form-group">
                <label for="inputmessage">Message</label>
                <textarea class="form-control" name="message" id="inputmessage" placeholder="Message..." rows="3" required ></textarea>
            </div>
            <div class="mb-3 text-center">
                <button class="btn btn-primary" type="submit">Send message</button>
            </div>
        </form>
        <div class="text-center">
            <hr class="my-4">
            <p class="lead text-muted"></p>For any suggestions or issues with our project you can comment our code directly on GitHub repository<p>
            <a href="https://github.com/infoshareacademy/jjdzl1-css-web" target="_blank" class="btn btn-primary my-2">Access repository</a>
        </div>
        </p>
    </div>
</section>
	  
    <div class="my-3 p-3 bg-light rounded box-shadow">
        <h6 class="border-bottom border-gray pb-2 mb-0">Our team</h6>
        <div class="media text-muted pt-3">
          <img src="https://avatars3.githubusercontent.com/u/44707917?s=40" alt="" class="mr-2 rounded">
          <div class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
            <div class="d-flex justify-content-between align-items-center w-100">
              <strong class="text-gray-dark">Dariusz Giza</strong>
              <a href="https://github.com/darek-giza" target="_blank">Follow</a>
            </div>
            <span class="d-block">@darek-giza</span>
          </div>
        </div>
        <div class="media text-muted pt-3">
          <img src="https://avatars2.githubusercontent.com/u/5605375?s=40" alt="" class="mr-2 rounded">
          <div class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
            <div class="d-flex justify-content-between align-items-center w-100">
              <strong class="text-gray-dark">Arkadiusz Szlachta</strong>
              <a href="https://github.com/arexe" target="_blank">Follow</a>
            </div>
            <span class="d-block">@arexe</span>
          </div>
        </div>
        <div class="media text-muted pt-3">
          <img src="https://avatars0.githubusercontent.com/u/36032024?s=40" alt="" class="mr-2 rounded">
          <div class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
            <div class="d-flex justify-content-between align-items-center w-100">
              <strong class="text-gray-dark">Łukasz Waręcki</strong>
              <a href="https://github.com/glenski2be7" target="_blank">Follow</a>
            </div>
            <span class="d-block">@glenski2be7</span>
          </div>
        </div>
		    <div class="media text-muted pt-3">
          <img src="https://avatars1.githubusercontent.com/u/39005373?s=40" alt="" class="mr-2 rounded">
          <div class="media-body pb-1 mb-0 small lh-125">
            <div class="d-flex justify-content-between align-items-center w-100">
              <strong class="text-gray-dark">Kamil Wawer</strong>
              <a href="https://github.com/Martin056PL" target="_blank">Follow</a>
            </div>
            <span class="d-block">@Martin056PL</span>
          </div>
        </div>
    </div>

<div class="my-3 p-3 bg-light rounded box-shadow">
    <h4 class="pb-2 mb-2"><i class="fas fa-location-arrow"></i> Where to find us</h4>
    <div class="responsive-map-container">
        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d11887.66878606692!2d22.62220996401687!3d51.21770292285432!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x4722568858a73987%3A0x92418d966e0add82!2sJ%C3%B3zefa+Franczaka+%22Lalka%22+43%2C+20-319+Lublin!5e0!3m2!1spl!2spl!4v1558290004993!5m2!1spl!2spl" width="600" height="450" frameborder="0" style="border:0" allowfullscreen></iframe>
    </div>
</div>