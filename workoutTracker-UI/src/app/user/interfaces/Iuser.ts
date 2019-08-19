export interface Iuser {
    username: string,
    fname: string,
    lname: string,
    age: number,
    admin: boolean,
    _id: string,
    _v: number
}

export class User implements Iuser{
    username: string;    
    fname: string;
    lname: string;
    age: number;
    admin: boolean;
    _id: string;
    _v: number;
}