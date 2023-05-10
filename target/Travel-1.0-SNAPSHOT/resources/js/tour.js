/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function loadAdminTours(endpoint) {
    fetch(endpoint).then(function (res) {
        return res.json();
    }).then(function (data) {
        console.info(data);
        let msg = "";
        for (let i = 0; i < data.length; i++) {
            msg += `
            <tr>
                <td><img src="${data[i].image}" width='110' /></td>
                <td>${data[i].name}</td>
                <td>${data[i].priceAdult} VND</td>
                <td>
                    <div class="spinner-border text-secondary" style="display:none" id="load${data[i].id}"></div>                   
                    <button class='btn btn-danger' onclick="delTour ('${endpoint + "/" + data[i].id}', ${data[i].id})">Xoa</button>
                </td>
            </tr>
            `;
        }
        let d = document.getElementById("adminTour");
        d.innerHTML = msg;

        let d2 =document.getElementById("myLoading");
        d2.style.display = "none";
    })

}


function delTour(endpoint, id) {
    let d = document.getElementById("load" + id);
    d.style.display = "block";
    fetch(endpoint, {
        method: "delete"
    }).then(function (res) {
        if (res.status === 204)
            location.reload();
    }).catch(function (err) {
        console.error(err);
    });
}

function loadComments(endpoint) {
    fetch(endpoint).then(function (res) {
        return res.json();
    }).then(function (data) {
        let h = '';
        for (let c of data) {
            h += `
                <li class="list-group-item" >${c.content} binh luan boi ${c.user.username} - ${moment(c.createdDate).locale("vi").fromNow()}</li>
            `
        }
        let co = document.getElementById("comments");
        co.innerHTML = h;
    })
}

function addComment(endpoint, id) {
    fetch(endpoint, {
        method: 'post',
        body: JSON.stringify({
            "content": document.getElementById("contentId").value,
            "tourId": id
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        return res.json();
    }).then(function (data) {
        let d = document.querySelector("#comments li:first-child");
        let h = `
                <li class="list-group-item">${data.content} - binh luan boi ${data.user.username} - ${moment(data.createdDate).locale("vi").fromNow()}</li>
            `
//        let f = document.querySelector("#comments li:first-child");
//        f.insertAdjacentHTML("beforebegin", h)
//        console.info(data);
        d.insertAdjacentHTML("beforebegin", h);
    });
}