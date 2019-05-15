window.onload = function(e) {
    updateNavbarLinkHighlighted();
}

var path;
var active;
var newActiveItemId;

function updateNavbarLinkHighlighted(){
    active = document.querySelector(".active");
    if (active != null) {
        removeActive();
    }
    highlightNew();
}

function removeActive(){
    active.classList.remove("active");
}

function highlightNew() {
    path = location.pathname.substring(1);

    newActiveItemId = pathMatches(/index|^[ \t\n]*$/) ? "nav-home" :
    pathMatches(/login|register/ ) ? "nav-login" :
    pathMatches(/profile|editaddress|changepassword|editinfo/) ? "nav-profile" :
    pathMatches(/admin/) ? "nav-admin" :
    pathMatches(/listAvailableCar|listReservationCurrentUser|searchCar|reservation|delete/) ? "nav-rsv" :
    pathMatches(/pricing/) ? "nav-pricing" :
    pathMatches(/contact/) ? "nav-contact" : "";

    var element = document.getElementById(newActiveItemId);
    if (element != null) {
        element.classList.add("active");
        element.classList.remove("text-dark");
    }
}

function pathMatches(regex) {
    if (path.match(regex)) {
        return true;
    }
    return false;
}