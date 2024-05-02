function changeValue(){
    var selectBox = document.getElementById("search-mth");
    var selectedValue = selectBox.options[selectBox.selectedIndex].value;
    // console.log(selectBox.selectedIndex);

    var rank_content = document.getElementById("mth-rank");
    var name_content = document.getElementById("mth-name");
    var age_content = document.getElementById("mth-age");
    var phone_content = document.getElementById("mth-phone-num");
    var email_content = document.getElementById("mth-email");
    var position_content = document.getElementById("mth-position");
    var submit_btn = document.getElementById("submit-btn");

    var field;

    switch(selectedValue){
        case "rank": clearAllDataInSearch(); field = document.getElementById("rank-input"); field.setAttribute("aria-required", "true"); rank_content.style.display = "block"; submit_btn.style.display = "block"; break;
        case "name": clearAllDataInSearch(); name_content.style.display = "block"; refreshList("name"); submit_btn.style.display = "block"; break;
        case "age": clearAllDataInSearch(); field = document.getElementById("min-age-in"); field.setAttribute("aria-required", "true"); field = document.getElementById("max-age-in"); field.setAttribute("aria-required", "true"); age_content.style.display = "block"; submit_btn.style.display = "block"; break;
        case "phone-num": clearAllDataInSearch(); phone_content.style.display = "block"; refreshList("phone-num"); submit_btn.style.display = "block"; break;
        case "email": clearAllDataInSearch(); email_content.style.display = "block"; refreshList("email"); submit_btn.style.display = "block"; break; 
        case "position": clearAllDataInSearch(); position_content.style.display = "block"; refreshList("position"); submit_btn.style.display = "block"; break;
        default: clearAllDataInSearch();
    }
}

function clearAllDataInSearch(){
    var rank_content = document.getElementById("mth-rank");
    var name_content = document.getElementById("mth-name");
    var age_content = document.getElementById("mth-age");
    var phone_content = document.getElementById("mth-phone-num");
    var email_content = document.getElementById("mth-email");
    var position_content = document.getElementById("mth-position");
    var submit_btn = document.getElementById("submit-btn");
    var field;

    field = document.getElementById("rank-input");
    field.setAttribute("aria-required", "false");
    field = document.getElementById("min-age-in");
    field.setAttribute("aria-required", "false");
    field = document.getElementById("max-age-in");
    field.setAttribute("aria-required", "false");

    rank_content.style.display = "none";
    name_content.style.display = "none";
    age_content.style.display = "none";
    phone_content.style.display = "none";
    email_content.style.display = "none";
    position_content.style.display = "none";
    submit_btn.style.display = "none"; 
}

function refreshList(keyword){
    var url_key = 'get-' + keyword;
    // console.log(url_key);

    var xhr = new XMLHttpRequest();
    xhr.open('POST', url_key, true);
    xhr.onreadystatechange = function() {
        if(xhr.readyState == XMLHttpRequest.DONE && xhr.status == 200){
            var values = JSON.parse(xhr.responseText);
            displayList(values, keyword);
        }
    };
    xhr.send();
}

function displayList(values, keyword){
    var idName = keyword + '-search';
    var valueList = document.getElementById(idName);

    while(valueList.options.length){
        valueList.remove(0);
    }

    values.forEach(function(value_in){
        var option = document.createElement('option');
        // option.setAttribute("class", "table-test");
        option.textContent = value_in;
        option.value = value_in;
        valueList.append(option);
    });
}

function refreshQueryList(){
    var xhr = new XMLHttpRequest();
    xhr.open('POST', 'get-search-result', true);
    xhr.onreadystatechange = function() {
        if(xhr.readyState == XMLHttpRequest.DONE && xhr.status == 200){
            var values = JSON.parse(xhr.responseText);
            addResult(values);
        }
    };
    xhr.send();
}

function addResult(values){
    var listDoc = document.getElementById('table-list');

    var tableHeaderValue = ['Rank', 'Name', 'Age', 'Email', 'Position'];

    while(listDoc.length){
        listDoc.remove(0);
    }

    values.forEach(function(person){
        var list = document.createElement('li');
        var tableMain = document.createElement('table');
        tableMain.setAttribute('class', 'result-table');
        var tableBody = document.createElement('tbody');
        var spaceList = document.createElement('br');

        for(var i = 0; i < 5; i++){
            var tableRow = document.createElement('tr');
            var tableHeader = document.createElement('th');
            tableHeader.textContent = tableHeaderValue[i];
            var tableData = document.createElement('td');
            tableData.textContent = person[i];

            tableRow.append(tableHeader);
            tableRow.append(tableData);
            tableBody.appendChild(tableRow);
        }

        tableMain.appendChild(tableBody);

        list.appendChild(tableMain);
        list.appendChild(spaceList);
        list.appendChild(spaceList);

        listDoc.appendChild(list);
    });
}