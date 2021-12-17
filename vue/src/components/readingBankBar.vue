<template>
  <div class="container">
    <div class="progress-bar"></div>
    <span class= "readingBankMinutes">{{totalMinutesRead}} Minutes Banked</span>
</div>
</template>

<script>
import ReadingActivityService from "@/services/ReadingActivityService.js";

export default {
  created() {
    this.readingBank();
  }, 

  computed() {
      this.readingBank();
  },

  data() {
    return {
      totalMinutesRead: 0,
      userId: this.$store.state.user.id
    }
  },

  methods: {
    readingBank() {
      ReadingActivityService.getTotalMinutesRead(this.userId).then((response) => {
        if (response.status == 200) {
          this.totalMinutesRead = response.data;
        } 
      });
    }
  }
}
</script>

<style>
.container {
  margin: 80px;
  height: 50px;
  background-color: #6939c3;
  position: relative;
  border-radius: 7px;
  border: 2px solid black;
  
}

.container .progress-bar {
  position:absolute;
  height: 100%;
  border-radius: 7px;
  background-color: rgb(125, 44, 255);
}

.container .readingBankMinutes {
  position: absolute;
  top: 50%;
  right: 25px;
  
  transform: translateY(-50%);
  font: bold 14px "Quicksand", sans-serif;
  color: white;
}

@keyframes progress-animation {
  0% { width: 0%;}
  100% { width: 100%;}

}

</style>