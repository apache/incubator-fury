import Fury, { TypeDescription, InternalSerializerType } from '@furyjs/fury';
import {describe, expect, test} from '@jest/globals';

describe('string', () => {
  test('should string work', () => {
    const hps = process.env.enableHps ? require('@furyjs/hps') : null;
    const fury = new Fury({ hps });    
    const input = fury.marshal("123")
    const result = fury.unmarshal(
        input
    );
    expect(result).toEqual("123")
  });
});


