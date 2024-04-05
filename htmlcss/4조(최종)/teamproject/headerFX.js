window.addEventListener('scroll', function () {
    const header = document.querySelector('.header');
    const logo = document.querySelector('img');
    if (window.scrollY > 50) {
        header.classList.add('scrolled');
        logo.classList.add('scrolled2');
    } else {
        header.classList.remove('scrolled');
        logo.classList.remove('scrolled2');
    }
});