<template>
  
  <div class="container">
  <div class="progress-bar"></div>
</div>
</template>

<script>
export default {
  
}
</script>

<style>
.container {
  height: 30px;
  background-color: green;
  position: relative;
  border-radius: 7px;
}

.container .progress-bar {
  position:absolute;
  height: 100%;
  border-radius: 7px;
  background-color: rgb(125, 44, 255);
  animation: progress-animation 5s infinite;
}

@keyframes progress-animation {
  0% { width: 0%;}
  100% { width: 100%;}
}

</style>