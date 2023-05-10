/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function generateColor() {
    let r = parseInt(Math.random() * 255)
    let g = parseInt(Math.random() * 255)
    let b = parseInt(Math.random() * 255)
    return `rgb(${r}, ${g}, ${b})`
    
}

function cateChart(id, cateLabels = [] , cateInfo = [] ) {
    let colors = []
    for (let i = 0;  i <  cateInfo.length; i++)
        colors.push(generateColor())
    
    const data = {
        labels: cateLabels,
        
        datasets: [{
                label: 'Thống kê doanh thu theo danh mục',
                data: cateInfo,
                backgroundColor: colors,
                hoverOffset: 4
            }]
    };

    const config = {
        type: 'pie',
        data: data
    };
    
    let ctx = document.getElementById(id).getContext("2d");
    
    return new Chart(ctx, config);

}

function prodChart(id, prodLabels =[], prodInfo = []){
       let colors = []
    for (let i = 0;  i <  prodInfo.length; i++)
        colors.push(generateColor())
    
    const data = {
        labels: prodLabels,
        
        datasets: [{
                label: 'Thống kê doanh thu theo sản phẩm',
                data: prodInfo,
                backgroundColor: colors,
                hoverOffset: 4
            }]
    };

    const config = {
        type: 'bar',
        data: data
        
        
    };
    
    let ctx = document.getElementById(id).getContext("2d");
    
    return new Chart(ctx, config);
    
}

function prodMonthChart(id, prodLabels =[], prodInfo = []){
       let colors = []
    for (let i = 0;  i <  prodInfo.length; i++)
        colors.push(generateColor())
    
    const data = {
        labels: prodLabels,
        
        datasets: [{
                label: 'Thống kê doanh thu theo tháng',
                data: prodInfo,
                backgroundColor: colors,
                hoverOffset: 4
            }]
    };

    const config = {
        type: 'bar',
        data: data
    };
    
    let ctx = document.getElementById(id).getContext("2d");
    
    return new Chart(ctx, config);
    
}