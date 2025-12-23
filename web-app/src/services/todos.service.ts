import { Todo } from "@/types/todo";
import {fetchResource} from "@/helpers/services"

const fetchTodo = async (method: "POST" | "GET" | "DELETE" | "PATCH", body?: object, pathVariables?: (string | number)[]) => fetchResource("todos", method, body, pathVariables)

export async function createTodo(title: Todo['title']): Promise<Todo | null> {
    const response = await fetchTodo("POST", {title})
    if(response.ok) return await response.json() 
    else return null
}

export async function updateTodo(id: Todo['id'], data: AllUndefined<Omit<Todo, "id">>): Promise<Todo| null> {
   const response = await fetchTodo("PATCH", data, [id])
    if(response.ok) return await response.json() 
    else return null
}

export async function deleteTodo(id: Todo['id']): Promise<Todo | null> {
    const response = await fetchTodo("DELETE", {}, [id])
    if(response.ok) return await response.json() 
    else return null
}

export async function listTodo(): Promise<Todo[]>{
    const response = await fetchTodo("GET")
    if(response.ok) return await response.json() 
    else return null
}

export async function getTodo(id: Todo['id']): Promise<Todo | null> {
    const response = await fetchTodo("GET", {}, [id])
    if(response.ok) return await response.json() 
    else return null
}