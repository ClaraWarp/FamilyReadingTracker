<template>
    <div>
        <h1 id="header"> Create a <span id="prize"> Prize </span> </h1>
        <create-prize/>
    </div>
</template>

<script>
import CreatePrize from "../components/CreatePrize.vue";
export default {
  components: { CreatePrize },
};
</script>

<style scoped>

#prize {
    color: #d4cb2a;
    font-weight: bolder;
    text-decoration: underline;
}

/* .wavy {
    text-decoration-line: underline;
    text-decoration-style: style;
    text-decoration-color: #d4cb2a;
} */

#header {
    text-align: center;
}

</style>