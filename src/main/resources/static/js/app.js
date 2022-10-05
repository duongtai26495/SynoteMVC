
function openMenuBar(){
    document.getElementById("side-bar").style.left = "0%"
}

function closeSideBar(){
   document.getElementById("side-bar").style.left = "-100%"
}

function closeUserBar(){
    document.getElementById("user-infor-tab").style.right = "-100%";
}

function openUserBar(){
    document.getElementById("user-infor-tab").style.right = "0%";
}


function uploadImage(file){
    if(file.files && file.files[0]){
        if(file.files[0].size > 500000){
            document.getElementById("label_upload").innerHTML = "<p class='text-danger'><i class='fa-solid fa-circle-xmark'></i> File too big</p>";
            file.files[0].remove;
        }else{
            var formdata = new FormData();
			formdata.append("image", file.files[0]);
            var requestOptions = {
            method: 'POST',
            body: formdata,
            redirect: 'follow'
            };
			const username = document.getElementById("username_field").value;
            fetch("/user/upload_image/"+username, requestOptions)
            .then(response => response.json())
            .then(result => {
                console.log(result.data)
                document.getElementById("image-selected").style.backgroundImage = "url(/user/images/"+username+")";
                document.getElementById("url_image_selected").setAttribute("value",result.data);
                file.files[0].remove;
                })
              .catch(error => console.log('error', error));
                }
        }
    }