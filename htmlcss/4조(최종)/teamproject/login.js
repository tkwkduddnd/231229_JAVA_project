window.onload = function () {
    const isLoggedIn = localStorage.getItem('isLoggedIn');
    const username = localStorage.getItem('username');

    if (isLoggedIn === 'true' && username) {
        const userUtility = document.querySelector('.util');
        userUtility.innerHTML = `
                    <span id="welcomeMessage">${username}님, 환영합니다!</span>
                    <a href="#" class="logoutButton" onclick="logout()">로그아웃</a>
                `;
    } else {
        const userUtility = document.querySelector('.util');
        userUtility.innerHTML = `
                    <a href="login.html" class="mLogin" title="임차문의로 이동">로그인</a>
                    <a href="signUp.html" class="mSignin" title="인재채용으로 이동">회원가입</a>
                `;
    }
};

function logout() {
    localStorage.removeItem('isLoggedIn');
    localStorage.removeItem('username');
    window.location.href = 'main.html';
}