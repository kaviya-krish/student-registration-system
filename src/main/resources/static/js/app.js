// =======================
// SIGNUP
// =======================

async function signup() {

    const user = {
        id: document.getElementById("id").value,
        name: document.getElementById("name").value,
        email: document.getElementById("email").value,
        password: document.getElementById("password").value
    };

    const response = await fetch("/signup", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(user)
    });

    const message = await response.text();

    if (message === "Registration Successful") {

        document.getElementById("message").style.color = "green";
        document.getElementById("message").innerHTML = message;

    } else {

        document.getElementById("message").style.color = "red";
        document.getElementById("message").innerHTML = message;
    }
}

// =======================
// LOGIN
// =======================
async function login() {

    const user = {
        email: document.getElementById("loginEmail").value,
        password: document.getElementById("loginPassword").value
    };

    const response = await fetch("/login", {

        method: "POST",

        headers: {
            "Content-Type": "application/json"
        },

        body: JSON.stringify(user)

    });

    if (response.ok) {

        const loggedInUser = await response.json();

        document.getElementById("loginMessage").style.color = "green";
        document.getElementById("loginMessage").innerHTML = "Login Successful";

        // Store actual logged-in user's ID
        localStorage.setItem("userId", loggedInUser.id);

        setTimeout(() => {
            window.location.href = "/dashboard";
        }, 1000);

    } else {

        const message = await response.text();

        document.getElementById("loginMessage").style.color = "red";
        document.getElementById("loginMessage").innerHTML = message;
    }
}


// =======================
// DASHBOARD
// =======================

async function loadDashboard() {

    const userId = localStorage.getItem("userId");

    if (!userId) {

        window.location.href = "/login";
        return;
    }

    const response = await fetch("/users/" + userId);

    if (!response.ok) {

        alert("User not found");
        return;
    }

    const user = await response.json();

    document.getElementById("welcome").innerHTML =
        "Welcome " + user.name + " 👋";

    document.getElementById("name").innerHTML = user.name;

    document.getElementById("email").innerHTML = user.email;

    if (user.course != null) {
        document.getElementById("course").innerHTML =
            user.course.courseName;
    } else {
        document.getElementById("course").innerHTML =
            "Not Registered";
    }

}


// =======================
// LOGOUT
// =======================

function logout() {

    localStorage.removeItem("userId");

    window.location.href = "/login";
}


// =======================
// AUTO LOAD DASHBOARD
// =======================

if (window.location.pathname === "/dashboard") {
    loadDashboard();
}

// =======================
// REGISTER COURSE
// =======================

async function loadCourses() {

    const response = await fetch("/courses");

    const courses = await response.json();

    let output = "";

    courses.forEach(course => {

        output += `
            <div class="course-card">

                <h3>${course.courseName}</h3>

                <p>Duration : ${course.duration}</p>

                <p>Fees : ₹${course.fees}</p>

                <button onclick="registerCourse(${course.id})">
                    Register
                </button>

            </div>
        `;
    });

    document.getElementById("courseList").innerHTML = output;

}

async function registerCourse(courseId){

    const userId = localStorage.getItem("userId");

    const response = await fetch(`/users/${userId}/course/${courseId}`,{

        method:"PUT"

    });

    const message = await response.text();

    alert(message);

}

if(window.location.pathname=="/courses-page"){
    loadCourses();
}