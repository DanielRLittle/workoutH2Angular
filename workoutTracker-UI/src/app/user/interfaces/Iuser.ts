export interface Iuser {
    username: string,
    fname: string,
    lname: string,
    age: number,
    admin: boolean,
    id: number
}

export class User implements Iuser{
    username: string;    
    fname: string;
    lname: string;
    age: number;
    admin: boolean;
    id: number;
}