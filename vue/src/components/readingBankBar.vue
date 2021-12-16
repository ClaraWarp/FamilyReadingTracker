<template>
  <div class="container">
    <div class="progress-bar"></div>
    <span class= "readingBankMinutes">0 Minutes Banked</span>
</div>
</template>

<script>
export default {
  
}
</script>

<style>
.container {
  margin: 100px;
  height: 50px;
  background-color: green;
  position: relative;
  border-radius: 7px;
  border: 1px solid black;
  
}

.container .progress-bar {
  position:absolute;
  height: 100%;
  border-radius: 7px;
  background-color: rgb(125, 44, 255);
  width: 50%;
  /* animation: progress-animation 5s infinite; */
}

.container .readingBankMinutes {
  position: absolute;
  top: 50%;
  right: 5px;
  transform: translateY(-50%);
  font: bold 14px "Quicksand", sans-serif;
  color: white;
}

@keyframes progress-animation {
  0% { width: 0%;}
  100% { width: 100%;}

}

</style>