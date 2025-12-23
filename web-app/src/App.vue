<script setup lang="ts">
import { onMounted, ref } from 'vue'
import { listTodo } from './services/todos.service'
import { Todo } from './types/todo'

const todoList = ref<Todo[]>([])  // initialise à un tableau vide

onMounted(async () => {
  todoList.value = await listTodo()
})
</script>

<template>
  <main>
    Nombre de todos : {{ todoList.length }}

    <ul>
      <li v-for="todo in todoList" :key="todo.id">
        {{ todo.title }}
      </li>
    </ul>
  </main>
</template>

<style scoped>
</style>
