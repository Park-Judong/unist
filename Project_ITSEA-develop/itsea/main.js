// 햄버거 메뉴 버튼
const toggleButton = document.querySelector('.navbar_toggleButton');
const menu = document.querySelector('.navbar_menu');
const sns = document.querySelector('.navbar_sns');

toggleButton.addEventListener('click', () => {
    menu.classList.toggle('active');
    sns.classList.toggle('active');
});

function hamburgerBtn() {
    var x = document.getElementById("myLinks");
    if (x.style.display === "block") {
        x.style.display = "none";
    } else {
        x.style.display = "block";
    }
}

// members button
const membersDownButton = document.querySelector('.members_downButton');
const membersUpButton = document.querySelector('.members_upButton');
const member = document.querySelector('.member');

membersDownButton.addEventListener('click', () => {
    member.classList.toggle('active');   
    $(".members_downButton").hide();
    $(".members_upButton").show();
    $(".member").show();
})

membersUpButton.addEventListener('click', () => {
    $(".members_downButton").show();
    $(".members_upButton").hide();
    $(".member").hide();
})
