<template>
  <div class="home">
    <span class="homeNav">
      <div id="family">
        <div class="twoLines">
          <h2 id="familyTitle">Family</h2>
          <div id="familyDetails">
            <div id="isParent"></div>
            <button id="joinFamilyButton" v-on:click = "addBook">Join Family</button>
          </div>
        </div>
        <div class="bookSection"></div>
      </div>
      <div id="reading"><h2>Reading Activity</h2><add-book/></div>
        <div>Add Book</div>
      <div id="prizes">
        <h2 class="prizeTitle">Prizes</h2>
        <a href="../components/CreatePrize.vue" id="createPrizeButton" target="_blank"><button>Create Prize</button></a>
        <div class="prizeSection"></div>
      </div>
    </span>
  </div>
</template>

<script>
//import familiesService from '@/services/FamiliesService.js'
import bookService from '@/services/BookService.js'
import AddBook from '../components/AddBook.vue';
export default {
  components: { 
    AddBook,
    },
  name: "home",
  methods:{
    addBook(){
      const dummyBook = {
        title: "newBook",
        author: "genius",
        isbn: "laskjdf",
        description: "my favorite book"
      }
      bookService.addBook(dummyBook).then(response=>{
        console.log(response.data)
      } )
    }

  }
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Nunito:wght@400;500&display=swap");

h2 {
  font-family: "Nunito", sans-serif;
  text-align: center;
  margin: 20px;
}

.prizeTitle {
  background-color: #f5cb5c;
  border-radius: 20px 0px 0px 20px;
  margin: 10px 0px 5px 10px;
  padding: 24px;
}

.prizeSection {
  flex-grow: 1;
  margin: 5px 0px 10px 10px;
  border-radius: 20px 0px 0px 20px;
  background-color: #f5cb5c;
}

.bookSection {
  flex-grow: 1;
  margin: 5px 10px 10px 0px;
  border-radius: 0px 20px 20px 0px;
  background-color: #a9d3ec;
}

.twoLines {
  line-height: 55px;
  margin: 10px 10px 5px 0px;
  border-radius: 0px 20px 20px 0px;
  padding: 5px;
  background-color: #a9d3ec;
}

.home {
  font-family: "Nunito", sans-serif;
}

.homeNav {
  display: grid;
  column-gap: 5px;
  height: 100vh;
  grid-template-columns: 1fr 1fr 1fr 1fr;
  grid-template-areas: "familyNav readingNav readingNav prizeNav";
}

#joinFamilyButton {
  color: white;
  background-color: #6939c3;
  border: 1px solid #6939c3;
  border-radius: 5px;
  padding: 2px 7px;
  margin: 2px 5px 5px 0px;
  font-size: 16px;
}

#joinFamilyButton:hover {
  color: #6930c3;
  background-color: white;
}

#isParent {
  flex-grow: 3;
}

#familyTitle {
  margin: 20px 20px 5px 20px;
}

#familyDetails {
  display: flex;
}

#family {
  grid-area: familyNav;
  display: flex;
  border: none;
  border-radius: 0px 20px 0px 0px;
  background-color: #6939c3;
  font-size: 35px;
  justify-content: flex-start;
  flex-direction: column;
}

#reading {
  grid-area: readingNav;
  display: flex;
  border: none;
  border-radius: 20px;
  justify-content: center;
  background-color: #53a6d9;
  font-size: 35px;
}

#prizes {
  grid-area: prizeNav;
  display: flex;
  border: none;
  border-radius: 20px 0px 0px 0px;
  background-color: #353535;
  font-size: 35px;
  justify-content: flex-start;
  flex-direction: column;
}

#createPrizeButton {
  color: white;
  background-color: #353535;
  border: 1px solid #353535;
  border-radius: 5px;
  padding: 2px 7px;
  margin: 2px 5px 5px 0px;
  font-size: 16px;
}
</style>
