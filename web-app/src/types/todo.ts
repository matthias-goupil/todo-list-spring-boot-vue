export enum TodoStatus {
    NEW, ONGOING, FINISH
}

export interface Todo {
    id: number;
    title: string;
    description: string | null;
    status: TodoStatus
}