const BASE_API_URL = "http://localhost:8080/api" 

export function getUrlResource(resourceName: string, pathVariables: (string | number)[] = []) {
    let url = `${BASE_API_URL}/${resourceName}`;

    // Remplacer les variables de chemin dans l'URL
    if(pathVariables.length) url += `/${pathVariables.join('/')}`
    

    return url;
}

export function fetchResource(resourceName: string, method: "POST" | "GET" | "DELETE" | "PATCH", body?: object, pathVariables?: (string | number)[]): Promise<Response> {
    return fetch(getUrlResource(resourceName, pathVariables), {
        method,             
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(body)  
    })
}
