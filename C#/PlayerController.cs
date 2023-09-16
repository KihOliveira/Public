using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerController : MonoBehaviour{
    [SerializeField] private GameInput gameInput;
    
    public void Update(){
        Vector2 inputVector = gameInput.GetMovementVectorNormalized();
        //movement
        Vector3 moveDir = new Vector3(inputVector.x , inputVector.y, 0);// (x, y, z)
        float moveSpeed = GetComponent<PlayerAttributes>().GetSpeed();
        transform.position += moveDir * Time.deltaTime * moveSpeed;
        
    }

}
